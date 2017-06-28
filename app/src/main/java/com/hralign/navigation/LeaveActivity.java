package com.hralign.navigation;

import android.app.DatePickerDialog;
import java.util.Calendar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
/**
 * Created by Carl_johnson on 11/28/2016.
 */
public class LeaveActivity extends MasterBaseActivity implements View.OnClickListener{

    ImageButton From_Date1, To_Date1 ;
    EditText FromDate1,ToDate1;
    private int mYear, mMonth, mDay;
    Context ctx;
    String activityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setLayout(R.layout.activity_leave);
        super.setDrawerID(R.id.leave_layout);
        super.onCreate(savedInstanceState);
        ctx = this.getBaseContext();
        activityName = "LeaveActivity";
        setContextFromActivity(ctx, activityName);

        From_Date1=(ImageButton)findViewById(R.id.FromDate);
        To_Date1=(ImageButton)findViewById(R.id.Todate);

        FromDate1=(EditText)findViewById(R.id.From_Date);
        ToDate1=(EditText)findViewById(R.id.To_date);

        From_Date1.setOnClickListener(this);
        To_Date1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

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
        if (v == To_Date1) {

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

                            ToDate1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

    }

}
