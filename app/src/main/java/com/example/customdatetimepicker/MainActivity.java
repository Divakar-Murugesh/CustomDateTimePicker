package com.example.customdatetimepicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customdatetimepicker.lib.SlideDateTimeListener;
import com.example.customdatetimepicker.lib.SlideDateTimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends FragmentActivity {

    TextView textView1, textView2, textView3;

    private SimpleDateFormat mFormatter1 = new SimpleDateFormat("dd MMM yyyy");
    private SimpleDateFormat mFormatter2 = new SimpleDateFormat("hh:mm aa");
    private SimpleDateFormat mFormatter3 = new SimpleDateFormat("dd MMM yyyy hh:mm aa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date initialDate = new Date();
                if (!textView1.getText().toString().equalsIgnoreCase("dd MMM yyyy")) {
                    try {
                        initialDate = mFormatter1.parse(textView1.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(new SlideDateTimeListener() {

                            @Override
                            public void onDateTimeSet(Date date) {
                                textView1.setText(mFormatter1.format(date));
                                Toast.makeText(MainActivity.this, mFormatter1.format(date), Toast.LENGTH_SHORT).show();
                            }

                            // Optional cancel listener
                            @Override
                            public void onDateTimeCancel() {
                                Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setInitialDate(initialDate)
                        .setDatePickerOnly()
                        //.setTimePickerOnly()
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        .setIndicatorColor(Color.parseColor("#5049BC"))
                        .build()
                        .show();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date initialDate = new Date();
                if (!textView2.getText().toString().equalsIgnoreCase("hh:mm aa")) {
                    try {
                        initialDate = mFormatter2.parse(textView2.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(new SlideDateTimeListener() {

                            @Override
                            public void onDateTimeSet(Date date) {
                                textView2.setText(mFormatter2.format(date));
                                Toast.makeText(MainActivity.this, mFormatter2.format(date), Toast.LENGTH_SHORT).show();
                            }

                            // Optional cancel listener
                            @Override
                            public void onDateTimeCancel() {
                                Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setInitialDate(initialDate)
                        //.setDatePickerOnly()
                        .setTimePickerOnly()
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        .setIndicatorColor(Color.parseColor("#5049BC"))
                        .build()
                        .show();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Date initialDate = new Date();
                if (!textView3.getText().toString().equalsIgnoreCase("dd MMM yyyy hh:mm aa")) {
                    try {
                        initialDate = mFormatter3.parse(textView3.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(new SlideDateTimeListener() {

                            @Override
                            public void onDateTimeSet(Date date) {
                                textView3.setText(mFormatter3.format(date));
                                Toast.makeText(MainActivity.this, mFormatter3.format(date), Toast.LENGTH_SHORT).show();
                            }

                            // Optional cancel listener
                            @Override
                            public void onDateTimeCancel() {
                                Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setInitialDate(initialDate)
                        //.setDatePickerOnly()
                        //.setTimePickerOnly()
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        .setIndicatorColor(Color.parseColor("#5049BC"))
                        .build()
                        .show();
            }
        });
    }
}
