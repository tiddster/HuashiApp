package net.muxi.huashiapp.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.muxi.huashiapp.R;
import net.muxi.huashiapp.common.data.News;

import java.util.List;

import butterknife.BindView;

/**
 * Created by december on 16/7/29.
 */
public class NewsDetailView extends RelativeLayout {

    @BindView(R.id.news_float_btn)
    ImageButton mNewsFloatBtn;
    @BindView(R.id.news_title)
    TextView mNewsTitle;
    @BindView(R.id.news_content)
    TextView mNewsContent;
    @BindView(R.id.news_date)
    TextView mNewsDate;
    @BindView(R.id.background_layout)
    LinearLayout mBackgroundLayout;
    private Context mContext;
    private List<News> mNewsList;


    public NewsDetailView(Context context, List<News> news) {
        super(context);
        mContext = context;
        mNewsList = news;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_news_detail, this, true);
        mNewsTitle.setText(mNewsList.get(0).getTitle());
        mNewsContent.setText(mNewsList.get(0).getContent());
        mNewsDate.setText(mNewsList.get(0).getDate());

    }
}