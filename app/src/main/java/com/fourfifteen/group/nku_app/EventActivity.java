package com.fourfifteen.group.nku_app;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class EventActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private TextView text;
    private String description;
    private String time;
    private String eventType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        text = findViewById(R.id.EventText);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        description = extras.getString("description");
        time = extras.getString("time");
        eventType = extras.getString("eventType");

        text.append("Event Description: "+description+"\n");
        text.append("Event Time: "+time+"\n");
        text.append("Event Type: "+eventType);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        int id = menuItem.getItemId();
                        switch(id){

                            case R.id.sign_out:
                                FirebaseAuth.getInstance().signOut();
                                finish();
                                Intent intent = new Intent(EventActivity.this, LoginActivity.class);
                                startActivity(intent);
                                return true;

                            case R.id.googleMap:
                                Intent mapIntent = new Intent(EventActivity.this, MapsActivity.class);
                                startActivity(mapIntent);
                                return true;

                            case R.id.calendar:
                                Intent calendarIntent = new Intent(EventActivity.this, CalendarActivity.class);
                                startActivity(calendarIntent);
                                return true;

                            case R.id.tasks:
                                Intent tasksIntent = new Intent(EventActivity.this, TasksActivity.class);
                                startActivity(tasksIntent);
                                return true;

                            case R.id.directory:
                                Intent directoryIntent = new Intent(EventActivity.this, DirectorySearchActivity.class);
                                startActivity(directoryIntent);
                                return true;

                            case R.id.parking:
                                Intent parkingIntent = new Intent(EventActivity.this, Parking.class);
                                startActivity(parkingIntent);
                                return true;

                            case R.id.home:
                                Intent home = new Intent(EventActivity.this, MainActivity.class);
                                startActivity(home);
                                return true;
                        }




                        menuItem.setChecked(true);

                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionbar.setTitle("Event");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            //case android.R.id.
        }
        return super.onOptionsItemSelected(item);
    }
}
