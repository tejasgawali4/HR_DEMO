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
public class AttendenceActivity extends MasterBaseActivity implements View.OnClickListener {

    ImageButton selectDate1, selectInTime1,SelectOutTime1;
    EditText select_Date1, Select_InTime1,Select_OutTime1;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Context ctx;
    String activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setLayout(R.layout.activity_attendence);
        super.setDrawerID(R.id.attendance_layout);
        super.onCreate(savedInstanceState);
        ctx = this.getBaseContext();
        activityName = "AttendenceActivity";
        setContextFromActivity(ctx, activityName);

        selectDate1=(ImageButton)findViewById(R.id.selectDate);
        selectInTime1=(ImageButton)findViewById(R.id.SelectInTime);
        SelectOutTime1=(ImageButton)findViewById(R.id.SelectOutTime);

        select_Date1=(EditText)findViewById(R.id.select_Date);
        Select_InTime1=(EditText)findViewById(R.id.Select_InTime);
        Select_OutTime1=(EditText)findViewById(R.id.Select_OutTime);

        selectDate1.setOnClickListener(this);
        selectInTime1.setOnClickListener(this);
        SelectOutTime1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if (v == selectDate1) {

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

                            select_Date1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == selectInTime1) {

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
        if (v == SelectOutTime1) {

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
