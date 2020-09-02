package net.muxi.huashiapp.ui.card;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import net.muxi.huashiapp.App;
import net.muxi.huashiapp.R;

public class MyMarkerView extends MarkerView {
    private TextView mNumTv, mSignalTv;

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        mNumTv = findViewById(R.id.tv_card_chart_marker_num);
        mSignalTv = findViewById(R.id.tv_card_chart_marker_signal);

    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        mNumTv.setText(String.format("%s", e.getY()));
        AssetManager mgr = App.getContext().getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "font/lao_sangam_mn.ttf");
        mNumTv.setTypeface(tf);
        mSignalTv.setTypeface(tf);
        super.refreshContent(e, highlight);
    }

    private MPPointF mOffset;

    @Override
    public MPPointF getOffset() {
        if(mOffset == null) {
            // center the marker horizontally and vertically
            mOffset = new MPPointF(-(getWidth() / 2), -getHeight());
        }
        return mOffset;
    }
}
