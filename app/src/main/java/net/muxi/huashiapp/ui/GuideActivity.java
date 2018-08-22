package net.muxi.huashiapp.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.muxistudio.appcommon.appbase.BaseAppActivity;

import net.muxi.huashiapp.R;
import net.muxi.huashiapp.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by december on 17/3/2.
 */

public class GuideActivity extends BaseAppActivity implements View.OnClickListener {

    private List<View> mViews;
    private ImageView[] indicatorImgs;
    private static final int GUIDE_PAGE_COUNT = 3;
    private int[] imgs = new int[]{R.drawable.bg_guide_4, R.drawable.bg_guide_5};
    private ViewPager mViewpager;
    private LinearLayout mIndicator;

    public static void start(Context context) {
        Intent intent = new Intent(context, GuideActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mViewpager = findViewById(R.id.viewpager);
        mIndicator = findViewById(R.id.indicator);
        initData();
        initView();
    }

    public void initData() {
        indicatorImgs = new ImageView[imgs.length];
        mViews = new ArrayList<View>(imgs.length);
        for (int i = 0; i < imgs.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_gudie, null);
            view.setBackgroundResource(R.color.colorWhite);
            ((SimpleDraweeView) view.findViewById(R.id.guide_image)).setImageURI(Uri.parse("res:/" + imgs[i]));
            if (i == imgs.length - 1) {
                Button mButton = (Button) view.findViewById(R.id.btn_confirm);
                mButton.setVisibility(View.VISIBLE);
                mButton.setTag("enter");
                mButton.setOnClickListener(this);
            }
            mViews.add(view);
            indicatorImgs[i] = new ImageView(this);
            if (i == 0) {
                indicatorImgs[i].setBackgroundResource(R.drawable.ic_indicators_selected);
            } else {
                indicatorImgs[i].setBackgroundResource(R.drawable.ic_indicators_default);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(20, 0, 0, 0);
                indicatorImgs[i].setLayoutParams(layoutParams);
            }
            mIndicator.addView(indicatorImgs[i]);
        }
    }

    public void initView() {
        mViewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(mViews.get(position));
                return mViews.get(position);
            }
        });
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void setIndicator(int targetIndex) {
        for (int i = 0; i < indicatorImgs.length; i++) {
            indicatorImgs[i].setBackgroundResource(R.drawable.ic_indicators_selected);
            if (targetIndex != i) {
                indicatorImgs[i].setBackgroundResource(R.drawable.ic_indicators_default);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            MainActivity.start(this);
            this.finish();
        }

    }
}
