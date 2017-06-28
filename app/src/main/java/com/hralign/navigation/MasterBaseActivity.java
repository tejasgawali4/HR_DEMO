package com.hralign.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MasterBaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Intent intent;
    DrawerLayout drawer;
    private int mLayoutRes=0;
    private int mDrawerID;
    private GestureDetectorCompat gestureDetectorCompat;
    Context ctx;
    Activity activity, mActivity;
    String actvityName, mActvityName;


    //    Boolean atLaunch = true;
    protected void setLayout(int layoutRes) {
        mLayoutRes = layoutRes;
    }
    protected void setDrawerID(int drawerID) {
        mDrawerID = drawerID;
    }

    protected void setContextFromActivity(Context mctx, String mActvityName) {
        ctx = mctx;
        actvityName = mActvityName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Layout Variable" +mLayoutRes);

        setContentView(mLayoutRes);
        drawer = (DrawerLayout) findViewById(mDrawerID);

        System.out.println("Layout Variable" +mLayoutRes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setOnTouchListener(new OnSwipeTouchListener(ctx) {

            public void onSwipeLeft() {
                switch  (actvityName){
                    case ".MainActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, LeaveActivity.class);
                            startActivity(intent);
                            break;
                        }else {
                            System.out.println("From MasterBase  ... onSwipeLeft...Activity is NULL...");
                        }
                    case "LeaveActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, AttendenceActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From MasterBase  ... onSwipeLeft...Activity is NULL...");
                        }
                    case "AttendenceActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, OdActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From AttendenceActivity ... onSwipeLeft...Activity is NULL...");
                        }
                    case "OdActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, MusterActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From OdActivity  ... onSwipeLeft...Activity is NULL...");
                        }
                    case "MusterActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, MainActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From MusterActivity  ... onSwipeLeft...Activity is NULL...");
                        }
                }
            }
            public void onSwipeRight() {
                switch  (actvityName){
                    case "MainActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, MusterActivity.class);
                            startActivity(intent);
                            break;
                        }else {
                            System.out.println("From MasterBase Activity ... onSwipeRight...Activity is NULL...");
                        }
                    case "LeaveActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, OdActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From MasterBase Activity ... onSwipeRight...Activity is NULL...");
                        }
                    case "AttendenceActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, AttendenceActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From MasterBase Activity ... onSwipeRight...Activity is NULL...");
                        }
                    case "OdActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, LeaveActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From MasterBase Activity ... onSwipeRight...Activity is NULL...");
                        }
                    case "MusterActivity":
                        if (ctx !=  null){
                            intent =  new Intent(ctx, MainActivity.class);
                            startActivity(intent);
                            break;
                        }else {

                            System.out.println("From MasterBase Activity ... onSwipeRight...Activity is NULL...");
                        }
                }
            }
            public void onSwipeBottom() {
            }
        });
    }

    @Override
    public void setContentView(int layoutResID)
    {
        DrawerLayout fullView = (DrawerLayout) getLayoutInflater().inflate(layoutResID, null, true);
        super.setContentView(fullView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void onBackPressed() {
        //      drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.leaveApply) {
            intent = new Intent(this, LeaveActivity.class);
            startActivity(intent);
        } else if (id == R.id.AttendanceApplication) {
            intent = new Intent(this, AttendenceActivity.class);
            startActivity(intent);
        } else if (id == R.id.OdApplication) {
            intent = new Intent(this, OdActivity.class);
            startActivity(intent);
        } else if (id == R.id.Musteroperation) {
            intent = new Intent(this, MusterActivity.class);
            startActivity(intent);
        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
