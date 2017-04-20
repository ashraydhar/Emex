package com.android.app.emex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


/**
 * This is the Navigation drawer activity with all fragments running in the window.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //    private SupportMapFragment sMapFragment;
//    private GoogleMap mMap;
    private HomePage homepage = new HomePage();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private JobHistory jobhistory = new JobHistory();
    private FragmentManager fragmentManager1 = getSupportFragmentManager();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        sMapFragment = SupportMapFragment.newInstance();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentManager.beginTransaction().replace(R.id.replace, homepage).commit();

//        sMapFragment.getMapAsync(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//        android.support.v4.app.FragmentManager sFm = getSupportFragmentManager();
//
//        if (sMapFragment.isAdded()) {
//            sFm.beginTransaction().hide(sMapFragment).commit();
//        }
        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction().replace(R.id.replace, homepage).commit();
            setTitle("Home");
        } else if (id == R.id.nav_networksView) {
//            setTitle("Networks View");
//            TextView textView = (TextView) findViewById(R.id.googleMap);
//            textView.setVisibility(View.VISIBLE);
//          fragmentManager2.beginTransaction().replace(R.id.replace,networksView).commit();
            Intent intent = new Intent(this, ReadyMadeMapsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_payment) {
            setTitle("Payment");
        } else if (id == R.id.nav_jobHistory) {
            fragmentManager1.beginTransaction().replace(R.id.replace, jobhistory).commit();
            setTitle("Job History");

        } else if (id == R.id.nav_emergencyContacts) {
            setTitle("Emergency Contacts");
        } else if (id == R.id.nav_help) {
            setTitle("Help");
        } else if (id == R.id.nav_logOut) {
            setTitle("Logging Out");
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
