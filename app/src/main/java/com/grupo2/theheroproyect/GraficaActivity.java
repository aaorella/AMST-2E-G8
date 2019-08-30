package com.grupo2.theheroproyect;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class GraficaActivity extends AppCompatActivity {

    String name;
    String fullName;
    ArrayList<String> nameStats;
    ArrayList<Integer> valueStats;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        name = getIntent().getExtras().getString("name");
        fullName = getIntent().getExtras().getString("fullName");
        nameStats = getIntent().getExtras().getStringArrayList("nameStats");
        valueStats = getIntent().getExtras().getIntegerArrayList("valueStats");


        barChart = (BarChart) findViewById(R.id.barchart);
        initBarchart();
        crearEntries();
        ((TextView)findViewById(R.id.nombre)).setText(name);
        ((TextView)findViewById(R.id.nombreCompleto)).setText(fullName);

    }

    private void initBarchart(){
        barChart.fitScreen();
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(90);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.animateY(1500);
        barChart.getLegend().setEnabled(false);
        String labels[] = new String[valueStats.size()];

        for (int i = 0; i<nameStats.size(); i++){
            labels[i] = nameStats.get(i);
        }
        IndexAxisValueFormatter i = new IndexAxisValueFormatter();
        i.setValues(labels);
        xAxis.setValueFormatter(i);

    }



    private void crearEntries(){
        System.out.println(valueStats);
        System.out.println(nameStats);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for(int i = 0; i<valueStats.size(); i++){
            String name = nameStats.get(i);
            Integer value = valueStats.get(i);
            BarEntry barEntry = new BarEntry(i, value);
            barEntries.add(barEntry);
        }
        crearDataset(barEntries);
    }
    private void crearDataset(ArrayList<BarEntry> barEntries){
        BarDataSet barDataSet = new BarDataSet(barEntries, "Stats Dataset");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(true);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet);
        BarData data = new BarData(dataSets);
        barChart.setData(data);
        barChart.setFitBars(true);
    }








}















