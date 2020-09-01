package net.muxi.huashiapp.ui.card;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.muxistudio.appcommon.data.CardSumData;

import net.muxi.huashiapp.R;

import java.util.ArrayList;
import java.util.List;

public class CardChartFragment extends Fragment {

    private LineChart mChart;

    public static CardChartFragment newInstance() {
        return new CardChartFragment();
    }

    public void setData(List<CardSumData> data) {

        List<Entry> chartData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            chartData.add(new Entry((float) i, (float) data.get(i).sum));
            System.out.println(data.get(i).time+"     "+data.get(i).sum);
        }

        LineDataSet lineDataSet = new LineDataSet(chartData, "金额");

        lineDataSet.setDrawCircles(true);

        lineDataSet.setColor(Color.parseColor("#3d81d1"));
        lineDataSet.setCircleColor(Color.parseColor("#3d81d1"));
        lineDataSet.setLineWidth(2f); //线宽
        lineDataSet.setCircleRadius(5f); //点的直径
        lineDataSet.setDrawCircleHole(true); //设置曲线值的圆点是实心还是空心
        lineDataSet.setHighLightColor(Color.parseColor("#9fb8d6"));
        lineDataSet.setValueTextSize(0); //值的数字大小
        lineDataSet.setFormSize(5f);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR); //线图设置为曲线

        Description description = mChart.getDescription();
        description.setText(""); // 设置右下角备注

        LineData lineData = new LineData(lineDataSet);
        mChart.setData(lineData);

        mChart.getXAxis().setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return data.get((int) value).time;
            }
        });


        XAxis xAxis = mChart.getXAxis();
        YAxis leftYAxis = mChart.getAxisLeft();
        YAxis rightYAxis = mChart.getAxisRight();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //X轴设置显示位置在底部
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        //保证Y轴从0开始，不然会上移一点
        leftYAxis.setAxisMinimum(0f);
        rightYAxis.setAxisMinimum(0f);

        xAxis.setDrawGridLines(false);
        rightYAxis.setDrawGridLines(false);
        leftYAxis.setDrawGridLines(true);
        rightYAxis.setDrawLabels(false);
        rightYAxis.setEnabled(false);
        leftYAxis.setDrawLabels(true);
        leftYAxis.enableGridDashedLine(10f, 10f, 0f);

        mChart.setTouchEnabled(true); // 设置是否可以触摸
        mChart.setDragEnabled(false);// 是否可以拖拽
        mChart.setScaleEnabled(false);// 是否可以缩放

        mChart.setDrawGridBackground(false); //是否展示网格线

        IMarker marker = new MyMarkerView(getContext(), R.layout.view_card_chart_marker);
        mChart.setMarker(marker);

        mChart.invalidate();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_detail_chart, container, false);
        mChart = view.findViewById(R.id.lc_card);
        return view;
    }
}
