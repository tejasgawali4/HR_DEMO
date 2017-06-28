package com.hralign.navigation;


import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;


/**
 * Created by Carl_johnson on 11/28/2016.
 */
public class MusterActivity extends MasterBaseActivity {

    private Button MusterIntimer;
    private Button MusterOuttimer;
    private TextView timer;
    Context ctx;
    String activityName;

    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.setLayout(R.layout.activity_muster);
        super.setDrawerID(R.id.muster_layout);
        super.onCreate(savedInstanceState);
        ctx = this.getBaseContext();
        activityName = "MusterActivity";
        setContextFromActivity(ctx, activityName);

        timer = (TextView) findViewById(R.id.Timer);
        MusterIntimer = (Button) findViewById(R.id.MusterIntimer);

        MusterIntimer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread, 0);

            }
        });

        MusterOuttimer = (Button) findViewById(R.id.MusterOuttimer);

        MusterOuttimer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

            }
        });
    }

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timer.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }

    };

}
