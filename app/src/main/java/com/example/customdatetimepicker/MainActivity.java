package com.example.customdatetimepicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customdatetimepicker.lib.SlideDateTimeListener;
import com.example.customdatetimepicker.lib.SlideDateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends FragmentActivity {

    TextView textView1, textView2, textView3;

    private SimpleDateFormat mFormatter1 = new SimpleDateFormat("dd MMM yyyy");
    private SimpleDateFormat mFormatter2 = new SimpleDateFormat("hh:mm aa");
    private SimpleDateFormat mFormatter3 = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(dateListener)
                        .setInitialDate(new Date())
                        .setDatePickerOnly()
                        //.setTimePickerOnly()
                        //.setBothPickers()
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        .setIndicatorColor(Color.parseColor("#5049BC"))
                        .build()
                        .show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(timeListener)
                        .setInitialDate(new Date())
                        //.setDatePickerOnly()
                        .setTimePickerOnly()
                        //.setBothPickers()
                        //.setMinDate(minDate)
                        //.setMaxDate(maxDate)
                        //.setIs24HourTime(true)
                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
                        .setIndicatorColor(Color.parseColor("#5049BC"))
                        .build()
                        .show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getSupportFragmentManager())
                        .setListener(dateTimeListener)
                        .setInitialDate(new Date())
                        //.setDatePickerOnly()
                        //.setTimePickerOnly()
                        .setBothPickers()
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

    private SlideDateTimeListener dateListener = new SlideDateTimeListener() {

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
    };
    private SlideDateTimeListener timeListener = new SlideDateTimeListener() {

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
    };
    private SlideDateTimeListener dateTimeListener = new SlideDateTimeListener() {

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
    };

}
