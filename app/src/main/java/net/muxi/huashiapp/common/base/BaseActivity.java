package net.muxi.huashiapp.common.base;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zhuge.analysis.stat.ZhugeSDK;

import net.muxi.huashiapp.R;
import net.muxi.huashiapp.util.Logger;
import net.muxi.huashiapp.widget.LoadingDialog;

/**
 * Created by ybao on 16/4/19.
 */
public class BaseActivity extends AppCompatActivity{

    protected Menu menu;
    protected ActionBar mActionBar;

    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
//        ZhugeSDK.getInstance().openDebug();
//        ZhugeSDK.getInstance().openLog();

    }

    public void setContentView(int layoutResId){
        super.setContentView(layoutResId);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }

    public void showLoading(){
        Logger.d("showloading");
        if (mLoadingDialog == null){
            mLoadingDialog = new LoadingDialog();
        }
        mLoadingDialog.show(getSupportFragmentManager(),"loading");
    }

    public void hideLoading(){
        Logger.d("hideloading");
        if (mLoadingDialog != null){
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //初始化分析跟踪
        ZhugeSDK.getInstance().init(getApplicationContext());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ZhugeSDK.getInstance().flush(getApplicationContext());
    }

    public void showSnackbarLong(String msg){
        Snackbar.make(getWindow().getDecorView(),msg,Snackbar.LENGTH_LONG)
                .show();
    }

    public void showSnackbarShort(String msg){
        Snackbar.make(getWindow().getDecorView(),msg,Snackbar.LENGTH_SHORT)
                .show();
    }

    public void showSnackbarLong(int resId){
        showSnackbarLong(getString(resId));
    }

    public void showSnackbarShort(int resId){
        showSnackbarShort(getString(resId));
    }

    public void showErrorSnackbarShort(int resId){
        showErrorSnackbarShort(getString(resId));
    }

    public void showErrorSnackbarShort(String msg){
        Snackbar snackbar;
        snackbar = Snackbar.make(findViewById(android.R.id.content),msg,Snackbar.LENGTH_SHORT)
                .setText(msg);
        View view = snackbar.getView();
        view.setBackgroundColor(getResources().getColor(R.color.red));
        snackbar.show();
    }
}
