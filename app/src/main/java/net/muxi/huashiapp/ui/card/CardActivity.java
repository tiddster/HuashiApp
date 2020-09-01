package net.muxi.huashiapp.ui.card;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.muxistudio.appcommon.appbase.ToolbarActivity;
import com.muxistudio.appcommon.data.CardAccount;
import com.muxistudio.appcommon.data.CardBalance;
import com.muxistudio.appcommon.data.CardDailyUse;
import com.muxistudio.appcommon.data.CardSumData;
import com.muxistudio.appcommon.presenter.CardDataPresenter;
import com.muxistudio.appcommon.utils.CommonTextUtils;
import com.muxistudio.appcommon.view.ICardView;
import com.muxistudio.appcommon.widgets.LoadingDialog;
import com.muxistudio.common.jsbridge.BridgeWebView;
import com.muxistudio.common.util.DateUtil;
import com.muxistudio.common.util.Logger;
import com.muxistudio.multistatusview.MultiStatusView;

import net.muxi.huashiapp.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by december on 16/7/18.
 */
public class CardActivity extends ToolbarActivity implements ICardView {

    private MultiStatusView mMultiStatusView;
    private TextView mMoney;
    private TextView mTvDate;
    private BridgeWebView mConsumeView;
    private TabLayout mDetailTl;
    private ViewPager mDetailVp;

    private CardDataPresenter mPresenter;
    private CardDailyUse mDailyUse;

    private CardDetailFragment mDetailFragment = CardDetailFragment.newInstance();
    private CardChartFragment mChartFragment = CardChartFragment.newInstance();
    private List<String> mTitles = new ArrayList<>();

    private LoadingDialog mLoadingDialog;

    public static void start(Context context) {
        Intent starter = new Intent(context, CardActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        initView();
        setTitle("校园卡");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        mPresenter = new CardDataPresenter(this);
        mPresenter.setCardView();

        mTitles.add("交易明细");
        mTitles.add("过去15天的消费图表");
        mDetailTl.addTab(mDetailTl.newTab().setText(mTitles.get(0)));
        mDetailTl.addTab(mDetailTl.newTab().setText(mTitles.get(1)));

        MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager(), mTitles);

        mDetailVp.setAdapter(mAdapter);
        mDetailTl.setupWithViewPager(mDetailVp);
        mDetailTl.setTabGravity(TabLayout.GRAVITY_FILL);
        mDetailTl.setTabTextColors(getResources().getColor(R.color.color_normal_tab), getResources().getColor(R.color.colorAccent));
        mDetailTl.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mDetailTl.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        mDetailTl.setTabMode(TabLayout.MODE_FIXED);

        //网页设置
//        WebSettings settings = mConsumeView.getSettings();
//        settings.setJavaScriptEnabled(true);
//        settings.setAppCacheEnabled(true);
//        settings.setAppCachePath("data/data/net.muxi.huashiapp/cache");
//        settings.setAppCacheMaxSize(1024 * 1024 * 8);
//        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

        mMultiStatusView.setOnRetryListener(v -> {
            mLoadingDialog = showLoading(CommonTextUtils.generateRandomLoginText());
            mPresenter = new CardDataPresenter(this);
            mPresenter.setCardView();
        });

    }

//    @Override
//    public void initView(CardDailyUse dailyUse, CardDataEtp etp) {
//        hideLoading();
//        mMultiStatusView.showContent();
//        mTvDate.setText("截止" + etp.getModel().getSmtDealdatetimeTxt());
//        mMoney.setText(etp.getModel().getBalance());
//        mDailyUse = dailyUse;
//
//
//
//        CardSumData[] data = new CardSumData[7];
//        for (int i = 0; i < data.length; i++) {
//         //   data[i] = new CardSumData(DateUtil.getTheDateInYear(new Date(), i - 6), getDailySum(i));
//
//        }
//
//
////        网页数据添加
////        Gson gson = new Gson();
////        String json = gson.toJson(data);
////
////        Logger.d(json);
////        mConsumeView.setInitData(data);
////        mConsumeView.loadUrl("https://ccnubox.muxixyz.com/api/consumechart/");
//    }

    @Override
    public void initView(CardAccount dailyUse, CardBalance cardBalance) {
        hideLoading();
        mMultiStatusView.showContent();
        mTvDate.setText(String.format("截止%s", DateUtil.getToday(new Date())));
           mMoney.setText(String.format("%s", Double.valueOf(cardBalance.getData().getBalance()).toString()));


        mDetailFragment.setData(dailyUse);


        List<CardSumData> data = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            data.add(new CardSumData(DateUtil.getTheDateInYear(new Date(), i - 14).substring(5,10), getDailySum(dailyUse, i)));

        mChartFragment.setData(data);

    }

    /**
     * 获取指定日的消费总额
     *
     * @param day 前七天为0，今天为6
     * @return
     */
    private Double getDailySum(CardAccount dailyUse, int day) {
        String date = DateUtil.getTheDateInYear(new Date(), -14 + day);
        Logger.d(date);
        double sum = 0;
        if (dailyUse.getData().getList().get(0) == null)
            return Double.valueOf(0);
        List<CardAccount.DataBean.ListBean> list = dailyUse.getData().getList();
        if (list == null || list.size() == 0 )
            return Double.valueOf(0);
        for (int i = 0, size = list.size(); i < size; i++) {
            if (list.get(i).getDealName().equals("消费"))
                if (date.equals(list.get(i).getDealDate().substring(0, 10))) {
                    sum += list.get(i).getTransMoney();
                }
        }
        Logger.d(sum + "");
        return sum;

    }

    private void initView() {
        mLoadingDialog = showLoading("正在查询");
        mMultiStatusView = findViewById(R.id.multi_status_view);
        mMoney = findViewById(R.id.money);
        mTvDate = findViewById(R.id.tv_date);
        //mConsumeView = findViewById(R.id.consume_view);
        mDetailTl = findViewById(R.id.tl_detail);
        mDetailVp = findViewById(R.id.vp_detail);
    }


    public class MyAdapter extends FragmentPagerAdapter {

        private List<String> mTitles;

        public MyAdapter(FragmentManager fm, List<String> titles) {
            super(fm);
            mTitles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return mDetailFragment;
                case 1: return mChartFragment;
            }
            return mDetailFragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }

}

