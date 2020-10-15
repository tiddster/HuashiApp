package net.muxi.huashiapp.ui.studyroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.muxistudio.appcommon.appbase.ToolbarActivity;
import com.muxistudio.appcommon.data.ClassRoom;
import com.muxistudio.appcommon.net.CampusFactory;
import com.muxistudio.appcommon.widgets.LoadingDialog;
import com.muxistudio.common.util.DimensUtil;
import com.muxistudio.common.util.Logger;
import com.muxistudio.multistatusview.MultiStatusView;

import net.muxi.huashiapp.R;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by december on 17/2/1.
 */

public class StudyRoomDetailActivity extends ToolbarActivity {

    private ClassRoom mClassRoom;
    private RelativeLayout mStudyDetailLayout;
    private MultiStatusView mMultiStatusView;
    private TextView mTitleStudyRoom1;
    private GridLayout mGridClassroom1;
    private TextView mTitleStudyRoom2;
    private GridLayout mGridClassroom2;
    private TextView mTitleStudyRoom3;
    private GridLayout mGridClassroom3;
    private TextView mTitleStudyRoom4;
    private GridLayout mGridClassroom4;
    private TextView mTitleStudyRoom5;
    private GridLayout mGridClassroom5;
    private TextView mTitleStudyRoom6;
    private GridLayout mGridClassroom6;
    private TextView mTitleStudyRoom7;
    private GridLayout mGridClassroom7;
    private TextView mTitleStudyRoom8;
    private GridLayout mGridClassroom8;
    private TextView mTitleStudyRoom9;
    private GridLayout mGridClassroom9;
    private TextView mTitleStudyRoom10;
    private GridLayout mGridClassroom10;
    private TextView mTitleStudyRoom11;
    private GridLayout mGridClassroom11;
    private TextView mTitleStudyRoom12;
    private GridLayout mGridClassroom12;
    private GridLayout[] mGridClassrooms;
    private TextView[] mTitleStudyRooms = new TextView[]{mTitleStudyRoom1, mTitleStudyRoom2,
            mTitleStudyRoom3, mTitleStudyRoom4, mTitleStudyRoom5, mTitleStudyRoom6, mTitleStudyRoom7,
            mTitleStudyRoom8, mTitleStudyRoom9, mTitleStudyRoom10, mTitleStudyRoom11, mTitleStudyRoom12};

    public static void start(Context context, String query) {
        Intent starter = new Intent(context, StudyRoomDetailActivity.class);
        starter.putExtra("query", query);
        context.startActivity(starter);
    }

    //查询参数
    private String mQuery;

    private ImageView img;


    //测试用直接查询
    private String mTest = "第5周周三7号楼";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyroom_detail);
        initView();
        setTitle("空闲教室列表");

        mQuery = getIntent().getStringExtra("query");
        Logger.d(mQuery + " ");
        mMultiStatusView.setOnRetryListener(v -> loadData());
        loadData();
    }

    private void loadData() {
        LoadingDialog loadingDialog = showLoading("正在请求空闲教室数据ing~");
        Subscription subscription = CampusFactory.getRetrofitService()
                .getClassRoom(getWeek(mQuery), getDayValue(mQuery), getBuidingValue(mQuery))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(classRoom -> {
                    mMultiStatusView.showContent();
                    mClassRoom = classRoom;
                    setNull();
                    setData();
                }, throwable -> {
                    throwable.printStackTrace();
                    mMultiStatusView.showNetError();
                    hideLoading();
                }, () -> hideLoading());

        loadingDialog.setOnSubscriptionCanceledListener(()->{
          if(!subscription.isUnsubscribed())
            subscription.unsubscribe();
        });

    }


    //返回数据为空时显示图片
    private void setNull() {
        img = new ImageView(this);
        img.setImageResource(R.drawable.img_empty_classroom);
        for ( int i = 0; i < mClassRoom.getData().getList().size(); i++) {
            List<String> rooms = mClassRoom.getData().getList().get(i).getRooms();
            if ( rooms == null || rooms.size() == 0 ){
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.leftMargin = DimensUtil.dp2px(94f);
                mGridClassrooms[i].addView(img, params);
            }
        }
    }


    private void setData() {

        for ( int i = 0 ; i < mClassRoom.getData().getList().size(); i++ ) {
            List<String> rooms = mClassRoom.getData().getList().get(i).getRooms();
            if ( rooms != null && rooms.size() > 0) {
                mGridClassrooms[i].setRowCount(30);
                mGridClassrooms[i].setColumnCount(4);
            }
            assert rooms != null;
            for (String room :rooms) {
                TextView context = new TextView(this);
                context.setTextColor(getResources().getColor(R.color.colorBlack));
                context.setText(room);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 2 * mGridClassrooms[i].getWidth() / 7;
                params.topMargin = DimensUtil.dp2px(16f);
                mGridClassrooms[i].addView(context, params);
            }
        }
    }


    /**
     * 转换星期格式为相应的查询参数
     *
     * @param str
     * @return
     */
    private String getDayValue(String str) {
        int index = str.indexOf("周");
        String s = str.substring(index + 1, index + 3);
        switch (s) {
            case "周一":
                s = "1";
                break;
            case "周二":
                s = "2";
                break;
            case "周三":
                s = "3";
                break;
            case "周四":
                s = "4";
                break;
            case "周五":
                s = "5";
                break;
        }
        return s;
    }

    private String getWeek(String str) {
        int index = str.indexOf("周");
        String s = str.substring(1, index);
        return s;
    }

    private String getBuidingValue(String str) {
        str = str.substring(str.lastIndexOf("周")+2);
        switch (str) {
            case "7号楼":
                return "7";
            case "8号楼":
                return "8";
            case "南湖综合楼":
                return "N";
        }
        return "7";
    }


    @Override
    public void onBackPressed() {
        StudyRoomCorrectView view = new StudyRoomCorrectView(StudyRoomDetailActivity.this);
        if (getWindow().getDecorView().equals(view)) {
            mStudyDetailLayout.removeView(view);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_studyroom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_correct) {
            StudyRoomCorrectView studyRoomCorrectView = new StudyRoomCorrectView(StudyRoomDetailActivity.this);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_show);
            studyRoomCorrectView.startAnimation(animation);
            mStudyDetailLayout.addView(studyRoomCorrectView);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mStudyDetailLayout = findViewById(R.id.study_detail_layout);
        mMultiStatusView = findViewById(R.id.multi_status_view);
        mTitleStudyRoom1 = findViewById(R.id.title_study_room_1);
        mGridClassroom1 = findViewById(R.id.grid_classroom_1);
        mTitleStudyRoom2 = findViewById(R.id.title_study_room_2);
        mGridClassroom2 = findViewById(R.id.grid_classroom_2);
        mTitleStudyRoom3 = findViewById(R.id.title_study_room_3);
        mGridClassroom3 = findViewById(R.id.grid_classroom_3);
        mTitleStudyRoom4 = findViewById(R.id.title_study_room_4);
        mGridClassroom4 = findViewById(R.id.grid_classroom_4);
        mTitleStudyRoom5 = findViewById(R.id.title_study_room_5);
        mGridClassroom5 = findViewById(R.id.grid_classroom_5);
        mTitleStudyRoom6 = findViewById(R.id.title_study_room_6);
        mGridClassroom6 = findViewById(R.id.grid_classroom_6);
        mTitleStudyRoom7 = findViewById(R.id.title_study_room_7);
        mGridClassroom7 = findViewById(R.id.grid_classroom_7);
        mTitleStudyRoom8 = findViewById(R.id.title_study_room_8);
        mGridClassroom8 = findViewById(R.id.grid_classroom_8);
        mTitleStudyRoom9 = findViewById(R.id.title_study_room_9);
        mGridClassroom9 = findViewById(R.id.grid_classroom_9);
        mTitleStudyRoom10 = findViewById(R.id.title_study_room_10);
        mGridClassroom10 = findViewById(R.id.grid_classroom_10);
        mTitleStudyRoom11 = findViewById(R.id.title_study_room_11);
        mGridClassroom11 = findViewById(R.id.grid_classroom_11);
        mTitleStudyRoom12 = findViewById(R.id.title_study_room_12);
        mGridClassroom12 = findViewById(R.id.grid_classroom_12);

        mGridClassrooms = new GridLayout[]{mGridClassroom1, mGridClassroom2,
                mGridClassroom3, mGridClassroom4, mGridClassroom5, mGridClassroom6, mGridClassroom7,
                mGridClassroom8, mGridClassroom9, mGridClassroom10, mGridClassroom11, mGridClassroom12};
    }
}
