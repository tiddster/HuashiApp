package net.muxi.huashiapp.news;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import net.muxi.huashiapp.R;
import net.muxi.huashiapp.common.base.ToolbarActivity;
import net.muxi.huashiapp.common.data.News;
import net.muxi.huashiapp.common.net.CampusFactory;
import net.muxi.huashiapp.common.util.DimensUtil;
import net.muxi.huashiapp.common.util.FrescoUtil;
import net.muxi.huashiapp.common.util.Logger;
import net.muxi.huashiapp.common.widget.BaseDetailLayout;
import net.muxi.huashiapp.common.widget.ShadowView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by december on 16/4/26.
 */
public class NewsActivity extends ToolbarActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.news_recycler_view)
    RecyclerView mNewsRecyclerView;
    @BindView(R.id.root_layout)
    FrameLayout mContentLayout;
    @BindView(R.id.drawee)
    SimpleDraweeView mDrawee;


    private FrameLayout mFrameLayout;

    public static final int FRAGMENT_HEIGHT =
            DimensUtil.getScreenHeight() - DimensUtil.getStatusBarHeight() - DimensUtil.dp2px(48);

    public static final int ACTIONBAR_DISTANCE = DimensUtil.dp2px(48) - DimensUtil.getActionbarHeight();

    public static final int DURATION_SCALE = 250;
    public static final int DURATION_ALPH = 180;

    private View animView;

    private View mShadowView;

    private BaseDetailLayout mBaseDetailLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        init();

        mFrameLayout = (FrameLayout) findViewById(android.R.id.content);

        CampusFactory.getRetrofitService().getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<News> newsList) {
                        setupRecyclerView(newsList);
                        mDrawee.setVisibility(View.GONE);
                    }
                });
    }

    public void init() {
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("消息公告");
        mNewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FrescoUtil.setLoading(mDrawee);
//        mNewsRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
    }


    private void setupRecyclerView(List<News> newsList) {
        MyNewsAdapter adapter;
        adapter = new MyNewsAdapter(newsList);
        mNewsRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyNewsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, List<News> newsList, int position) {
                Logger.d("balalala");
                setupDetailLayout(newsList, position);

                final View itemView = view;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addShadowView();
                        startScale(itemView);
                    }
                }, DURATION_ALPH);
            }
        });
    }


    private void addShadowView() {
        mShadowView = new ShadowView(NewsActivity.this);
        mShadowView.setBackgroundColor(Color.BLACK);
        mShadowView.setAlpha(0.6f);
        mContentLayout.addView(mShadowView);
    }

    private void setupDetailLayout(final List<News> newsList, final int position) {
        Observable.timer(DURATION_ALPH + DURATION_SCALE, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mBaseDetailLayout = new BaseDetailLayout(NewsActivity.this);
                        mContentLayout.addView(mBaseDetailLayout);
                        NewsDetailView newsDetailView = new NewsDetailView(NewsActivity.this, newsList, position);
                        mBaseDetailLayout.setContent(newsDetailView);

                    }
                });
    }


    private void startScale(View view) {
        int viewTop = view.getTop();
        int viewHeight = view.getHeight();
        animView = new View(NewsActivity.this);
        animView.setBackgroundColor(Color.WHITE);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                viewHeight
        );
        params.setMargins(0, viewTop + DimensUtil.getActionbarHeight(), 0, 0);
        mFrameLayout.addView(animView, params);
        animView.setBackgroundColor(Color.WHITE);

        final ScaleAnimation scaleAnimation = new ScaleAnimation(
                1,
                1,
                1,
                FRAGMENT_HEIGHT / (float) viewHeight,
                0,
                (float) ((viewTop - ACTIONBAR_DISTANCE) * 1.0 / ((float) FRAGMENT_HEIGHT * 1.0 / (float) viewHeight - 1))
        );

        scaleAnimation.setDuration(DURATION_SCALE);
        scaleAnimation.setFillAfter(true);

        animView.startAnimation(scaleAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (animView != null) {
                    mFrameLayout.removeView(animView);
                    animView = null;
                }
            }
        }, DURATION_SCALE);

    }

    @Override
    public void onBackPressed() {

        if (mBaseDetailLayout != null) {
            mBaseDetailLayout.slideContentView();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mContentLayout.removeView(mBaseDetailLayout);
                    mContentLayout.removeView(mShadowView);
                    mShadowView = null;
                    mBaseDetailLayout = null;
                }
            }, 250);
            return;
        }
        super.onBackPressed();
    }

}

