package net.muxi.huashiapp.ui.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.muxistudio.appcommon.net.CampusFactory;
import com.muxistudio.common.util.Logger;
import com.muxistudio.common.util.PreferenceUtil;
import com.muxistudio.common.util.RootCheck;
import com.muxistudio.common.util.SignCheck;

import net.muxi.huashiapp.App;
import net.muxi.huashiapp.R;
import net.muxi.huashiapp.ui.more.CheckUpdateDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class SplashActivity extends AppCompatActivity {


    private Button button;
    private SimpleDraweeView draweeView;
    public  final String TAG="Splash";
    private Context context;
    private Subscription subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        button=findViewById(R.id.splash_button);
        draweeView=(SimpleDraweeView) findViewById(R.id.splash_drawee);
        button.setVisibility(View.INVISIBLE);
        context=this;
        //SignCheck signCheck = new SignCheck(this, "B0:82:FE:46:80:04:1F:47:5C:6F:8D:DD:30:3D:6C:6C:06:1A:AC:83");
//        SignCheck signCheck = new SignCheck(this, "75:95:6A:19:CC:49:96:EB:E7:88:BC:FB:ED:23:8C:DB:7F:3C:89:32");
//        if(signCheck.check()) {
//            if (RootCheck.checkRootWhichSU()) {
//                CheckUpdateDialog checkUpdateDialog1 = new CheckUpdateDialog();
//                checkUpdateDialog1.setTitle("启动失败");
//                checkUpdateDialog1.setContent("本应用禁止在Root设备上使用");
//                checkUpdateDialog1.setOnPositiveButton("确认", ()->{
//                    checkUpdateDialog1.dismiss();
//                    System.exit(0);
//                });
//                checkUpdateDialog1.show(getSupportFragmentManager(), "dialog_root");
//            }else {
//                getConfig();
//                button.setOnClickListener(v -> {
//                    unsubscribe();
//                    MainActivity.start(context);
//                    finish();
//                });
//            }
//        } else {
//            CheckUpdateDialog checkUpdateDialog2 = new CheckUpdateDialog();
//            checkUpdateDialog2.setTitle("应用签名错误");
//            checkUpdateDialog2.setContent("请前往华师匣子官网（ccnubox.muxixyz.com）下载正版App");
//            checkUpdateDialog2.setOnPositiveButton("确认", () -> {
//                checkUpdateDialog2.dismiss();
//                System.exit(0);
//            });
//            checkUpdateDialog2.show(getSupportFragmentManager(), "dialog_sign");
//        }

        getConfig();
        button.setOnClickListener(v -> {
            unsubscribe();
            MainActivity.start(context);
            finish();
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unsubscribe();
    }

    public void unsubscribe(){
        if (subscription!=null){
            if (subscription.isUnsubscribed())
                subscription.unsubscribe();
        }
    }
    public void getConfig(){


       subscription= CampusFactory.getRetrofitService().getConfig()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(config -> {
                    Logger.i(TAG+" getConfig: "+config.getConfig().getCalendarUrl());
                    PreferenceUtil.saveString(PreferenceUtil.FIRST_WEEK_DATE,config.getConfig().getStartCountDayPresetForV2());
                    PreferenceUtil.saveString(PreferenceUtil.CALENDAR_ADDRESS,config.getConfig().getCalendarUrl());
                    DateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
                    String cur=dataFormat.format(new Date());
                    if (cur.compareTo(config.getConfig().getFlashStartDay())>=0&&cur.compareTo(config.getConfig().getFlashEndDay())<=0){
                        Logger.i(TAG+" getConfig: display");
                        draweeView.setVisibility(View.VISIBLE);
                        draweeView.setImageURI(config.getConfig().getFlashScreenUrl());
                        button.setVisibility(View.VISIBLE);
                        return Observable.interval(1, TimeUnit.SECONDS)
                                .takeUntil(aLong -> {
                                       return (3-aLong)==0;
                                });
                    }else
                        return Observable.empty();
                }).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {
                Logger.i(TAG+" onCompleted: ");
                if (context!=null)
                    MainActivity.start(context);
                finish();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (context!=null)
                    MainActivity.start(context);
                finish();
            }

            @Override
            public void onNext(Long aLong) {
                button.setText(String.format(Locale.CHINA,"跳过 %d", 3 - aLong));
            }
        });


    }
}
