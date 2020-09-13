package net.muxi.huashiapp.ui.electricity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.muxistudio.appcommon.appbase.ToolbarActivity;
import com.muxistudio.appcommon.net.CampusFactory;
import com.muxistudio.common.util.NoDoubleClickUtil;
import com.muxistudio.common.util.PreferenceUtil;

import net.muxi.huashiapp.R;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by december on 16/6/27.
 */
public class ElectricityActivity extends ToolbarActivity {

    private TextView mArea1;
    private TextView mArea2;
    private TextView mArea3;
    private TextView mArea4;
    private TextView mArea5;
    private TextView mHintChooseArea;
    private TextView mTvArea;
    private TextView mHintChooseRoom;
    private TextView mTvRoom;
    private Button mBtnSearch;

    public static void start(Context context) {
        Intent starter = new Intent(context, ElectricityActivity.class);
        context.startActivity(starter);
    }

    private String[] mBuildings = new String[19];

    private TextView[] mArea;

    //东区对应的建筑
    private static final String[] buildingStrings1 = {
            "东区1栋", "东区2栋", "东区3栋", "东区4栋", "东区5栋", "东区6栋", "东区7栋", "东区8栋",
            "东区9栋", "东区10栋", "东区11栋", "东区12栋", "东区13栋东", "东区13栋西", "东区14栋",
            "东区15栋东", "东区15栋西", "东区16栋", "东区附1栋"};

    //西区对应的建筑
    private static final String[] buildingStrings2 = {
            "西区1栋", "西区2栋", "西区3栋 西3", "西区4栋 西4", "西区5栋 西5", "西区6栋 西6", "西区7栋", "西区8栋"};

    //元宝山对应的建筑
    private static final String[] buildingStrings3 = {
            "元宝山1栋", "元宝山2栋", "元宝山3栋", "元宝山4栋", "元宝山5栋"};

    //南湖对应的建筑
    private static final String[] buildingStrings4 = {
            "南湖1栋", "南湖2栋", "南湖3栋", "南湖4栋", "南湖5栋", "南湖6栋", "南湖7栋", "南湖8栋",
            "南湖9栋", "南湖10栋", "南湖11栋", "南湖12栋", "南湖13栋"};

    //国交对应的建筑
    private static final String[] buildingStrings5 = {
            "国交4栋", "国交8栋", "国交9栋"};

    //查询参数
    private String mQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity);

        mToolbar.setTitle("电费查询");
        initView();
        mArea = new TextView[]{mArea1, mArea2, mArea3, mArea4, mArea5};
    }

    private void initView() {
        mArea1 = findViewById(R.id.area_1);
        mArea2 = findViewById(R.id.area_2);
        mArea3 = findViewById(R.id.area_3);
        mArea4 = findViewById(R.id.area_4);
        mArea5 = findViewById(R.id.area_5);

        mHintChooseArea = findViewById(R.id.hint_choose_area);
        mTvArea = findViewById(R.id.tv_area);
        mHintChooseRoom = findViewById(R.id.hint_choose_room);
        mTvRoom = findViewById(R.id.tv_room);
        mBtnSearch = findViewById(R.id.btn_search);

        mArea1.setOnClickListener(v -> onClick(v));
        mArea2.setOnClickListener(v -> onClick(v));
        mArea3.setOnClickListener(v -> onClick(v));
        mArea4.setOnClickListener(v -> onClick(v));
        mArea5.setOnClickListener(v -> onClick(v));

        mTvArea.setOnClickListener(v -> onClick(v));
        mHintChooseArea.setOnClickListener(v -> onClick(v));

        mTvRoom.setOnClickListener(v -> onClick(v));
        mHintChooseRoom.setOnClickListener(v -> onClick(v));

        mBtnSearch.setOnClickListener(v -> onClick(v));

        mArea1.setBackgroundResource(R.drawable.shape_green);
        mArea1.setTextColor(Color.WHITE);
        mTvArea.setText("东区1栋");
        mBuildings = buildingStrings1;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            switch (requestCode) {
                case 0:
                    mTvArea.setText(data.getStringExtra("area"));
                    break;
                case 1:
                    mTvRoom.setText(data.getStringExtra("room"));
                    break;
            }
        }
    }

    //对应各个寝室
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.area_1) {
            setBackground(0);
            mTvArea.setText("东区1栋");
            mBuildings = buildingStrings1;
        } else if (id == R.id.area_2) {
            setBackground(1);
            mTvArea.setText("西区1栋");
            mBuildings = buildingStrings2;
        } else if (id == R.id.area_3) {
            setBackground(2);
            mTvArea.setText("元宝山1栋");
            mBuildings = buildingStrings3;
        } else if (id == R.id.area_4) {
            setBackground(3);
            mTvArea.setText("南湖1栋");
            mBuildings = buildingStrings4;
        } else if (id == R.id.area_5) {
            setBackground(4);
            mTvArea.setText("国交4栋");
            mBuildings = buildingStrings5;
        } else if ((id == R.id.tv_area || id == R.id.hint_choose_area) && !NoDoubleClickUtil.isDoubleClick()) {
            //选择所在区域具体的寝室号码
            Intent intent = new Intent(ElectricityActivity.this, ElectricityAreaOptionActivity.class);
            intent.putExtra("type", "area");
            intent.putExtra("buildings", mBuildings);
            startActivityForResult(intent, 0);
        } else if ((id == R.id.tv_room || id == R.id.hint_choose_room) && !NoDoubleClickUtil.isDoubleClick()) {
            //选择所在楼栋具体寝室号
            Intent intent = new Intent(ElectricityActivity.this, ElectricityAreaOptionActivity.class);
            intent.putExtra("type", "room");
            if (getAlias() != null)
                CampusFactory.getRetrofitService().getDormitory(getAlias())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(dormitoryList -> {
                            String[] buildingList = new String[dormitoryList.getData().getCount()];
                            for (int i = 0; i < dormitoryList.getData().getCount(); i++)
                                buildingList[i] = dormitoryList.getData().getList().get(i);
                            intent.putExtra("buildings", buildingList);
                        }, throwable -> {
                            showErrorSnackbarShort("请检查网络");
                            throwable.printStackTrace();
                        }, () -> {
                            startActivityForResult(intent, 1);
                        });
        } else if (id == R.id.btn_search) {
            if (mTvArea.getText().length() != 0 && mTvRoom.getText().toString().length() != 0) {
                StringBuffer temp = new StringBuffer();
                temp.append(getAlias());
                temp.append(" ");
                temp.append(mTvRoom.getText().toString());
                mQuery = temp.toString();
                PreferenceUtil sp = new PreferenceUtil();
                PreferenceUtil.saveString(PreferenceUtil.ELE_QUERY_STRING, mQuery);

                ElectricityDetailActivity.start(this, mQuery);
                this.finish();
            }
        }
    }

    private String getAlias() {
        if (mTvArea.getText().length() != 0) {
            String area = mTvArea.getText().toString();
            StringBuffer alias = new StringBuffer();
            if (area.charAt(0) == '东') {
                alias.append('东');
                if (area.charAt(2) > '9' || area.charAt(2) < '0') {
                    alias.append('附');
                    alias.append(area, 3, area.indexOf("栋"));
                } else {
                    int index = area.indexOf("栋");
                    alias.append(area, 2, index);
                    if (index + 1 < area.length()) {
                        alias.append("-");
                        alias.append(area.charAt(area.length() - 1));
                    }
                }
            } else if (area.charAt(0) == '西') {
                alias.append('西');
                alias.append(area, 2, area.indexOf("栋"));
            } else if (area.charAt(0) == '南') {
                alias.append(area, 0, area.length() - 1);
            } else if (area.charAt(0) == '国') {
                alias.append('国');
                alias.append(area, 2, area.indexOf("栋"));
            } else if (area.charAt(0) == '元') {
                alias.append('元');
                alias.append(area, 3, area.indexOf("栋"));
            }
            return alias.toString();
        } else
            return null;
    }

    //选中的时候设置为绿色 其他时候为黑色
    private void setBackground(int position) {
        for (int i = 0; i < 5; i++) {
            if (i == position) {
                mArea[i].setBackgroundResource(R.drawable.shape_green);
                mArea[i].setTextColor(Color.WHITE);
            } else {
                mArea[i].setBackgroundResource(R.drawable.shape_disabled);
                mArea[i].setTextColor(getResources().getColor(R.color.disable_color));
            }

        }

    }


}
