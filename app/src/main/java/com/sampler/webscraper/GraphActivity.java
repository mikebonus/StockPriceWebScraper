package com.sampler.webscraper;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    // Bar-Chart
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        barChart = findViewById(R.id.BarChart);
        SetData();

        barDataSet=new BarDataSet(barEntries,"");
        barData=new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(12f);

        // adding labels
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("1");
        xAxisLabel.add("2");
        xAxisLabel.add("3");
        xAxisLabel.add("4");
        xAxisLabel.add("5");
        xAxisLabel.add("6");
        xAxisLabel.add("7");
        xAxisLabel.add("8");
        xAxisLabel.add("9");
        xAxisLabel.add("10");

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        ValueFormatter formatter = new ValueFormatter() {

            @Override
            public String getFormattedValue(float value) {
                return xAxisLabel.get((int) value);
            }
        };

        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
    }


    private void SetData(){
        barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(0f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getONE_VALUE())));
        barEntries.add(new BarEntry(1f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getTWO_VALUE())));
        barEntries.add(new BarEntry(2f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getTHREE_VALUE())));
        barEntries.add(new BarEntry(3f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getFOUR_VALUE())));
        barEntries.add(new BarEntry(4f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getFIVE_VALUE())));
        barEntries.add(new BarEntry(5f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getSIX_VALUE())));
        barEntries.add(new BarEntry(6f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getSEVEN_VALUE())));
        barEntries.add(new BarEntry(7f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getEIGHT_VALUE())));
        barEntries.add(new BarEntry(8f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getNINE_VALUE())));
        barEntries.add(new BarEntry(9f,Float.parseFloat(MainActivity.TestKotlinConstantClass.Companion.getTEN_VALUE())));
    }
}
