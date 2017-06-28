package com.hralign.navigation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import java.util.Calendar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by Carl_johnson on 11/28/2016.
 */
public class OdActivity extends MasterBaseActivity implements View.OnClickListener {

    ImageButton From_Date1 , To_date1, SelectInTime1 ,Select_outTime1;
    EditText FromDate1,Todate, Select_InTime1,Select_OutTime1;
    private int  mYear , mMonth , mDay , mHour , mMinute;
    Context ctx;
    String activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setLayout(R.layout.activity_od);
        super.setDrawerID(R.id.od_layout);
        super.onCreate(savedInstanceState);
        ctx = this.getBaseContext();
        activityName = "OdActivity";
        setContextFromActivity(ctx, activityName);

        From_Date1=(ImageButton)findViewById(R.id.FromDate);
        To_date1=(ImageButton)findViewById(R.id.Todate);
        SelectInTime1=(ImageButton)findViewById(R.id.SelectInTime);
        Select_outTime1=(ImageButton)findViewById(R.id.SelectOutTime);

        FromDate1=(EditText)findViewById(R.id.From_Date);
        Todate=(EditText)findViewById(R.id.To_date);
        Select_InTime1=(EditText)findViewById(R.id.Select_InTime);
        Select_OutTime1=(EditText)findViewById(R.id.Select_OutTime);

        From_Date1.setOnClickListener(this);
        To_date1.setOnClickListener(this);
        SelectInTime1.setOnClickListener(this);
        Select_outTime1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if (v == From_Date1) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            FromDate1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == To_date1) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            Todate.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == SelectInTime1) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            Select_InTime1.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == Select_outTime1) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            Select_OutTime1.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
