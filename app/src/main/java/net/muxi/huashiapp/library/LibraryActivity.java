package net.muxi.huashiapp.library;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import net.muxi.huashiapp.App;
import net.muxi.huashiapp.R;
import net.muxi.huashiapp.common.OnItemClickListener;
import net.muxi.huashiapp.common.data.Book;
import net.muxi.huashiapp.common.util.DimensUtil;
import net.muxi.huashiapp.common.widget.ShadowView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ybao on 16/5/1.
 */
public class LibraryActivity extends AppCompatActivity implements BookDetailView.OnScrollListener{

    // TODO: 16/5/3 material searchView has bug ...

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.root_layout)
    RelativeLayout mRootLayout;
    @Bind(R.id.frame_layout)
    FrameLayout mFrameLayout;

    private FrameLayout contentLayout;

    //设置fragment 的高度
    public static final int FRAGMENT_HEIGHT =
            DimensUtil.getScreenHeight() - DimensUtil.getStatusBarHeight() - DimensUtil.getActionbarHeight() - DimensUtil.dp2px(50);
    //设置 fragment 距离actionbar的距离
    public static final int ACTIONBAR_DISTANCE = DimensUtil.dp2px(50);
    //animView 扩张的时间
    public static final int TIME_STRETCH = 300;
    //文字隐藏,展现的时间
    public static final int TIME_ALPH = 200;
    //变换的 view 的下滑时间
    public static final int TIME_SLIDE = 200;
    //toolbar 的滑动时间
    public static final int TIME_TOOLBAR_SLIDE = 200;
    @Bind(R.id.searchview)
    MaterialSearchView mSearchview;


    //点击后详情页布局
    private RelativeLayout detailLayout;
    private Toolbar detailToolbar;
    private BookDetailView mBookDetailView;

    private LibraryAdapter mLibraryAdapter;
    private View animView;

    private View mItemView;

    private View mShadowView;

    private int my;
    private int curY;

    //详情页未出现的状态
    public static final int NOT_APPEAR = 0;
    //详情页出现,处于最上方的状态
    public static final int APPEAR_TOP = 1;
    //详情页已经向下滑动的状态
    public static final int SLIDE_DOWN = 4;
    //详情页滑到 toolbar 出现的状态
    public static final int TOOLBAR_APPEAR = 2;
    //详情页滑动toolbar 消失状态
    public static final int TOOLBAR_DISAPPEAR = 3;
    //往下滑但释放不足以下拉详情列表
    public static int detailState = NOT_APPEAR;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);

        contentLayout = (FrameLayout) findViewById(android.R.id.content);
        setupRecyclerview();

        mSearchview.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("feng", "feng");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        mToolbar.setTitle("图书馆");
        setSupportActionBar(mToolbar);


        App.setCurrentActivity(this);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);

    }


    @Override
    public void onScroll(int scrollY) {
        Log.d("scrollY", scrollY + "");
        if (detailState != TOOLBAR_APPEAR && scrollY > DimensUtil.getScreenHeight() + DimensUtil.getActionbarHeight() + ACTIONBAR_DISTANCE) {
            initDetailToolbar("详情");
            slideDownToolbar();
            detailState = TOOLBAR_APPEAR;
        }
        if (detailState == TOOLBAR_APPEAR && scrollY < DimensUtil.getScreenHeight() + DimensUtil.getActionbarHeight() + ACTIONBAR_DISTANCE) {
            slideUpToolbar();
            detailState = TOOLBAR_DISAPPEAR;
        }
    }

    private void slideUpToolbar() {
        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -DimensUtil.getActionbarHeight());
        animation.setDuration(TIME_TOOLBAR_SLIDE);
        animation.setFillBefore(true);
        animation.setFillAfter(true);
        detailToolbar.startAnimation(animation);
    }

    private void slideDownToolbar() {
        TranslateAnimation animation = new TranslateAnimation(0, 0, -DimensUtil.getActionbarHeight(), 0);
        animation.setDuration(TIME_TOOLBAR_SLIDE);
        animation.setFillAfter(true);
        detailToolbar.startAnimation(animation);
    }

    private void initDetailToolbar(String title) {
        if (detailToolbar == null) {
            detailToolbar = new Toolbar(LibraryActivity.this);
            detailToolbar.setTitle(title);
            detailToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            detailToolbar.setNavigationIcon(R.drawable.delete_edit_login);
            detailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            RelativeLayout.LayoutParams toolbarParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            );
            toolbarParams.setMargins(0, -DimensUtil.getActionbarHeight(), 0, 0);
            contentLayout.addView(detailToolbar, toolbarParams);
        }

    }

    private void setupRecyclerview() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        String[] s = new String[17];
        for (int i = 0; i < 17; i++) {
            s[i] = "it is the title " + i;
        }
        mLibraryAdapter = new LibraryAdapter(s);
        mRecyclerView.setAdapter(mLibraryAdapter);

        mLibraryAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, Book book) {

                hideItem(view);
//                addShadowView();
                startScale(view);
                addScrollView();

                mItemView = view;
//                addDetailViewGroup();

            }

        });
    }

    private void addShadowView() {
        mShadowView = new ShadowView(LibraryActivity.this);
        contentLayout.addView(mShadowView);
    }

    private void addScrollView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBookDetailView = new BookDetailView(LibraryActivity.this);
                mBookDetailView.setBackgroundColor(Color.alpha(Color.WHITE));
//                mBookDetailView.scrollTo(0,DimensUtil.getScreenHeight());
                contentLayout.addView(mBookDetailView);
                forceScrollTo(mBookDetailView, DimensUtil.getScreenHeight());
                mBookDetailView.setOnScrollListener(LibraryActivity.this);
//                mBookDetailView.getViewTreeObserver().addOnScrollChangedListener(LibraryActivity.this);
            }
        }, TIME_ALPH + TIME_STRETCH);
        detailState = APPEAR_TOP;

    }


//    @Override
//    public void onScrollChanged() {
//        if (detailState != TOOLBAR_APPEAR &&
//                mBookDetailView.getScrollY() > DimensUtil.getScreenHeight() + DimensUtil.getActionbarHeight() + ACTIONBAR_DISTANCE) {
//            initDetailToolbar("详情");
//            slideDownToolbar();
//            detailState = TOOLBAR_APPEAR;
//        }
//        if (detailState == TOOLBAR_APPEAR &&
//                mBookDetailView.getScrollY() < DimensUtil.getScreenHeight() + DimensUtil.getActionbarHeight() + ACTIONBAR_DISTANCE) {
//            slideUpToolbar();
//            detailState = TOOLBAR_DISAPPEAR;
//        }
//        if (mBookDetailView.getScrollY() > DimensUtil.getScreenHeight() + DimensUtil.getActionbarHeight()){
//            onBackPressed();
//        }else if (mBookDetailView.getScrollY() < DimensUtil.getScreenHeight() + DimensUtil.getActionbarHeight()
//                && mBookDetailView.getScrollY() > DimensUtil.getScreenHeight()){
//            mBookDetailView.smoothScrollTo(0,DimensUtil.getScreenHeight());
//        }
//    }

    //强制 scrollview 滑动
    public void forceScrollTo(final ScrollView scrollView, final int deltaY) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, deltaY);
            }
        });
    }


    private void startScale(View view) {
        int viewTop = view.getTop();
        int viewHeight = view.getHeight();
        animView = new View(LibraryActivity.this);
        animView.setBackgroundColor(Color.BLUE);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                viewHeight
        );
        params.setMargins(0, viewTop + DimensUtil.getActionbarHeight(), 0, 0);
        contentLayout.addView(animView, params);
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1,
                1,
                1,
                FRAGMENT_HEIGHT / viewHeight,
                0,
                (float) ((viewTop - ACTIONBAR_DISTANCE) * 1.0 / (FRAGMENT_HEIGHT / viewHeight - 1))
        );

        scaleAnimation.setStartTime(TIME_ALPH);
        scaleAnimation.setDuration(TIME_STRETCH + TIME_ALPH);
        scaleAnimation.setFillAfter(true);
        animView.startAnimation(scaleAnimation);

    }


    private void hideItem(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(TIME_ALPH);
        view.setAnimation(alphaAnimation);
    }

    private void showItem(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(TIME_ALPH);
        view.setAnimation(alphaAnimation);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_library, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        mSearchview.setMenuItem(item);
        return true;
    }


    //当当前有详情页显示时,改写后退键的方法
    @Override
    public void onBackPressed() {
        Log.d("onback","onback");
        if (detailState != NOT_APPEAR){
            if (detailState == TOOLBAR_APPEAR){
                slideUpToolbar();
            }
            mBookDetailView.slideDetailLayoutBottom();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    contentLayout.removeView(detailToolbar);
                    removeView();
                    detailState = NOT_APPEAR;
                }
            },1000);
            return;
        }
        super.onBackPressed();
    }


    //移除详情页
    private void removeView() {
        contentLayout.removeView(mBookDetailView);
        contentLayout.removeView(mShadowView);
        Log.d("dimen", "" + (contentLayout.getBottom() - contentLayout.getTop()));

//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0,
//                DimensUtil.getActionbarHeight() + ACTIONBAR_DISTANCE, FRAGMENT_HEIGHT);
//        translateAnimation.setDuration(TIME_SLIDE * 10);
//        translateAnimation.setFillAfter(true);
//        animView.startAnimation(translateAnimation);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                contentLayout.removeView(animView);
//            }
//        }, 1000);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                my = (int)ev.getY();
//                if (mBookDetailView != null && mBookDetailView.getScrollY() == 0){
//                    detailState = APPEAR_TOP;
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//                curY = (int) ev.getY();
//                if (detailState == APPEAR_TOP && (curY - my) > 0){
//                    mBookDetailView.scrollBy(0,my - curY);
//                    Log.d("dispatch","false");
//                    return false;
//                }
//                break;
//        }
//        return super.dispatchTouchEvent(ev);
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                my = (int)event.getY();
//                if (mBookDetailView != null && mBookDetailView.getScrollY() == 0){
//                    detailState = APPEAR_TOP;
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
//                curY = (int)event.getY();
//                if (detailState == APPEAR_TOP && (curY - my ) > 0 ){
//                    mBookDetailView.scrollBy(0,my - curY);
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                if (detailState == APPEAR_TOP && mBookDetailView.getScrollY() < -DimensUtil.getActionbarHeight()){
//                    slideDownScrollView();
//                }
//        }
//        Log.d("LibraryActivity","feng");
//        return super.onTouchEvent(event);
//
//    }


//    private void slideDownScrollView() {
//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, -mScrollView.getScrollY(), DimensUtil.getScreenHeight());
//        translateAnimation.setFillAfter(true);
//        translateAnimation.setDuration(TIME_STRETCH);
//        mScrollView.startAnimation(translateAnimation);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                contentLayout.removeView(mScrollView);
//                contentLayout.removeView(mShadowView);
//
//            }
//        }, TIME_STRETCH);
//
//    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}