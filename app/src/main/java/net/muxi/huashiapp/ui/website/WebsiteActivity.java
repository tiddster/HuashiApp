package net.muxi.huashiapp.ui.website;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.muxistudio.appcommon.appbase.ToolbarActivity;
import com.muxistudio.appcommon.data.WebsiteData;
import com.muxistudio.appcommon.db.HuaShiDao;
import com.muxistudio.appcommon.net.CampusFactory;

import com.muxistudio.appcommon.widgets.LoadingDialog;
import net.muxi.huashiapp.R;
import net.muxi.huashiapp.ui.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by december on 16/11/2.
 */

public class WebsiteActivity extends ToolbarActivity {

    private RecyclerView mRecyclerView;
    private LoadingDialog mLoadingDialog;
    private WebsiteAdapter adapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, WebsiteActivity.class);
        context.startActivity(starter);
    }

    private HuaShiDao mDao;
    private List<WebsiteData> mWebsiteDatas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        initView();
        mDao = new HuaShiDao();
        try {
            mWebsiteDatas = mDao.loadSite();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mLoadingDialog = showLoading("校园网站正在加载中~");
        setTitle("常用网站");

        if (mWebsiteDatas != null && mWebsiteDatas.size() > 0) {
            //学生信息服务平台暂时无法使用
            CampusFactory.getRetrofitService().getWebsite()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Observer<List<WebsiteData>>() {
                        @Override
                        public void onCompleted() {
                            hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            hideLoading();
                            setupRecyclerView(filterData(mWebsiteDatas));
                            showSnackbarShort(getString(R.string.tip_net_error));
                        }

                        @Override
                        public void onNext(List<WebsiteData> websiteData) {
                            if (mWebsiteDatas == null || websiteData.size() != mWebsiteDatas.size()) {
                                //学生信息服务平台暂时无法使用
                                setupRecyclerView(filterData(websiteData));
                                mDao.deleteWebsite();
                                for (WebsiteData data : websiteData) {
                                    mDao.insertSite(data);
                                }
                            }
                        }
                    });
        }else {
            Subscription subscription = CampusFactory.getRetrofitService().getWebsite()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Observer<List<WebsiteData>>() {
                        @Override
                        public void onCompleted() {
                            hideLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            hideLoading();
                            e.printStackTrace();
                            showSnackbarShort(getString(R.string.tip_net_error));
                        }

                        @Override
                        public void onNext(List<WebsiteData> websiteData) {
                            if (mWebsiteDatas == null || websiteData.size() != mWebsiteDatas.size()) {
                                //学生信息服务平台暂时无法使用
                                setupRecyclerView(filterData(websiteData));
                                mDao.deleteWebsite();
                                for (WebsiteData data : websiteData) {
                                    mDao.insertSite(data);
                                }
                            }
                        }
                    });

            mLoadingDialog.setOnSubscriptionCanceledListener(
                    () -> {
                        if (!subscription.isUnsubscribed())
                            subscription.unsubscribe();
                    });
        }
    }

    public void setupRecyclerView(List<WebsiteData> websiteData) {
        adapter.refreshData(websiteData);
    }

    private List filterData(List<WebsiteData> dataList) {
        List<WebsiteData> filteredList = new ArrayList<>();
        for (WebsiteData data : dataList) {
            if (!data.getSite().equals("学生信息服务平台")) {
                filteredList.add(data);
            }
        }
        return filteredList;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    private void initView() {
        adapter = new WebsiteAdapter(new ArrayList<>());
        adapter.setOnItemClickListener((view, websiteData1, position) -> {
            if ( websiteData1.get(position).getSite().contains("教务管理系统")) {
                Intent intent = WebViewActivity.newIntent(WebsiteActivity.this, "https://account.ccnu.edu.cn/cas/login?service=http%3A%2F%2Fxk.ccnu.edu.cn%2Fsso%2Fpziotlogin");
                startActivity(intent);
            } else {
                Intent intent = WebViewActivity.newIntent(WebsiteActivity.this, websiteData1.get(position).getUrl());
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
