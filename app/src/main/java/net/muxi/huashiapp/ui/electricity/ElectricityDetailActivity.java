package net.muxi.huashiapp.ui.electricity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.muxistudio.appcommon.appbase.ToolbarActivity;
import com.muxistudio.appcommon.data.ElectricityResponse;
import com.muxistudio.appcommon.net.CampusFactory;
import com.muxistudio.common.util.PreferenceUtil;
import com.muxistudio.multistatusview.MultiStatusView;
import com.umeng.analytics.MobclickAgent;

import net.muxi.huashiapp.R;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by december on 16/7/7.
 */
public class ElectricityDetailActivity extends ToolbarActivity {

    private RelativeLayout mEleDetailLayout;
    private MultiStatusView mMultiStatusView;
    private TextView mPayHint;


    private TextView mTvAirTime;
    private TextView mTvLightTime;
    private TextView mTvMoreTime;

    private TextView mTvAirLeft;
    private TextView mTvLightLeft;
    private TextView mTvMoreLeft;

    private TextView mTvAirUsage;
    private TextView mTvLightUsage;
    private TextView mTvMoreUsage;

    private TextView mTvAirCharge;
    private TextView mTvLightCharge;
    private TextView mTvMoreCharge;

    private TextView mTvAirLeftSign;
    private TextView mTvLightLeftSign;
    private TextView mTvMoreLeftSign;

    private TextView mTvAirLeftUnit;
    private TextView mTvLightLeftUnit;
    private TextView mTvMoreLeftUnit;

    private CardView mCardAir;
    private CardView mCardLight;
    private CardView mCardMore;


    public static void start(Context context, String query) {
        Intent starter = new Intent(context, ElectricityDetailActivity.class);
        starter.putExtra("query", query);
        context.startActivity(starter);
    }

    private static final String PAY_HINT = "电费不足？查看如何微信缴费";
    private String mQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_detail);
        initView();
        showLoading("正在加载中");
        setTitle("查询结果");
        PreferenceUtil sp = new PreferenceUtil();
        mQuery = getIntent().getStringExtra("query");
        mMultiStatusView.setOnRetryListener(v -> {
            loadData();
        });
        setFontType(PAY_HINT);
        loadData();

    }

    private void loadData() {
        Subscription subscriptionEle = CampusFactory.getRetrofitService().getElectricity(mQuery.split(" ")[0], mQuery.split(" ")[1])
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(electricityResponse -> {
                    if (electricityResponse.getCode() == 0) {
                        setData(electricityResponse);
                        mMultiStatusView.showContent();
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                    mMultiStatusView.showNetError();
                    hideLoading();

                }, this::hideLoading);
    }

    public void setData(ElectricityResponse electricityResponse) {

        mCardAir.setCardBackgroundColor(getResources().getColor(R.color.color_card_air_one));
        mCardLight.setCardBackgroundColor(getResources().getColor(R.color.color_card_light_one));
        mCardMore.setCardBackgroundColor(getResources().getColor(R.color.color_card_air_two));

        if ( electricityResponse.getData().isHas_more() ) {
            mTvMoreLeft.setText(String.format("%s", electricityResponse.getData().getMore_data().get(0).getRemain_power()));
            mTvMoreTime.setText(String.format("抄表时间：%s", electricityResponse.getData().getMore_data().get(0).getRead_time()));
            mTvMoreUsage.setText(String.format("昨日用电：%s度", electricityResponse.getData().getMore_data().get(0).getConsumption().getUsage()));
            mTvMoreCharge.setText(String.format("昨日电费：%s元", electricityResponse.getData().getMore_data().get(0).getConsumption().getCharge()));
        } else
            mCardMore.setVisibility(View.GONE);

        if ( electricityResponse.getData().isHas_air() ) {
            mTvAirLeft.setText(String.format("%s", electricityResponse.getData().getAir().getRemain_power()));
            mTvAirTime.setText(String.format("抄表时间：%s", electricityResponse.getData().getAir().getRead_time()));
            mTvAirUsage.setText(String.format("昨日用电：%s度", electricityResponse.getData().getAir().getConsumption().getUsage()));
            mTvAirCharge.setText(String.format("昨日电费：%s元", electricityResponse.getData().getAir().getConsumption().getCharge()));
        } else {
            mTvAirLeft.setText("");
            mTvAirTime.setText("");
            mTvAirUsage.setText("");
            mTvAirCharge.setText("");
            mTvAirLeftUnit.setText("");
            mTvAirLeftUnit.setVisibility(View.INVISIBLE);
            mTvAirLeft.setVisibility(View.INVISIBLE);
            mTvAirTime.setVisibility(View.INVISIBLE);
            mTvAirUsage.setVisibility(View.INVISIBLE);
            mTvAirCharge.setVisibility(View.INVISIBLE);
            mTvAirLeftSign.setText("暂时查询不到");
        }

        if ( electricityResponse.getData().isHas_light() ) {
            mTvLightLeft.setText(String.format("%s", electricityResponse.getData().getLight().getRemain_power()));
            mTvLightTime.setText(String.format("抄表时间：%s", electricityResponse.getData().getLight().getRead_time()));
            mTvLightUsage.setText(String.format("昨日用电：%s度", electricityResponse.getData().getLight().getConsumption().getUsage()));
            mTvLightCharge.setText(String.format("昨日电费：%s元", electricityResponse.getData().getLight().getConsumption().getCharge()));
        } else {
            mTvLightLeft.setText("");
            mTvLightTime.setText("");
            mTvLightUsage.setText("");
            mTvLightCharge.setText("");
            mTvLightLeftUnit.setText("");
            mTvLightLeftUnit.setVisibility(View.INVISIBLE);
            mTvLightLeft.setVisibility(View.INVISIBLE);
            mTvLightTime.setVisibility(View.INVISIBLE);
            mTvLightUsage.setVisibility(View.INVISIBLE);
            mTvLightCharge.setVisibility(View.INVISIBLE);

            mTvLightLeftSign.setText("暂时查询不到");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_electricity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_change_room) {

            MobclickAgent.onEvent(this, "ele_fee_change_dom_query");
            PreferenceUtil sp = new PreferenceUtil();
            PreferenceUtil.clearString(PreferenceUtil.ELE_QUERY_STRING);
            Intent intent = new Intent(ElectricityDetailActivity.this, ElectricityActivity.class);
            startActivity(intent);
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }

    //设置特定位置字体变换颜色
    private void setFontType(String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)), 5, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mPayHint.setText(spannableString);
    }

    public void onClick() {
        ElectricityPayHintView view = new ElectricityPayHintView(this);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_show);
        view.startAnimation(animation);
        mEleDetailLayout.addView(view);

    }


    @Override
    public void onBackPressed() {
        ElectricityPayHintView view = new ElectricityPayHintView(this);
        if (getWindow().getDecorView().equals(view)) {
            view.getAnimation().cancel();
            mEleDetailLayout.removeView(view);
        } else {
            super.onBackPressed();
        }

    }

    private void initView() {
        mEleDetailLayout = findViewById(R.id.ele_detail_layout);
        mMultiStatusView = findViewById(R.id.multi_status_view);

        mCardAir = findViewById(R.id.card_air);
        mCardLight = findViewById(R.id.card_light);
        mCardMore = findViewById(R.id.card_more);

        mTvAirTime = findViewById(R.id.tv_air_time);
        mTvAirLeft = findViewById(R.id.tv_air_left);
        mTvAirUsage = findViewById(R.id.tv_air_usage);
        mTvAirCharge = findViewById(R.id.tv_air_charge);
        mTvAirLeftSign = findViewById(R.id.tv_air_left_sign);
        mTvAirLeftUnit = findViewById(R.id.tv_air_left_unit);

        mTvLightTime = findViewById(R.id.tv_light_time);
        mTvLightLeft = findViewById(R.id.tv_light_left);
        mTvLightUsage = findViewById(R.id.tv_light_usage);
        mTvLightCharge = findViewById(R.id.tv_light_charge);
        mTvLightLeftSign = findViewById(R.id.tv_light_left_sign);
        mTvLightLeftUnit = findViewById(R.id.tv_light_left_unit);

        mTvMoreTime = findViewById(R.id.tv_more_time);
        mTvMoreLeft = findViewById(R.id.tv_more_left);
        mTvMoreUsage = findViewById(R.id.tv_more_usage);
        mTvMoreCharge = findViewById(R.id.tv_more_charge);
        mTvMoreLeftSign = findViewById(R.id.tv_more_left_sign);
        mTvMoreLeftUnit = findViewById(R.id.tv_more_left_unit);

        mPayHint = findViewById(R.id.pay_hint);
        mPayHint.setOnClickListener(v -> onClick());
    }
}
