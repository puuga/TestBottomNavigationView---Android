package com.puuga.testbottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_container, AFragment.newInstance())
                    .commit();
        }
    }

    private void initInstances() {
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.action_favorites:
                Log.d("btm_nev", "action_favorites");

                fragment = getSupportFragmentManager().findFragmentById(R.id.content_container);
                if (!(fragment instanceof AFragment)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_container, AFragment.newInstance())
                            .commit();
                }
                break;
            case R.id.action_schedules:
                Log.d("btm_nev", "action_schedules");

                fragment = getSupportFragmentManager().findFragmentById(R.id.content_container);
                if (!(fragment instanceof BFragment)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_container, BFragment.newInstance())
                            .commit();
                }
                break;
            case R.id.action_music:
                Log.d("btm_nev", "action_music");

                fragment = getSupportFragmentManager().findFragmentById(R.id.content_container);
                if (!(fragment instanceof CFragment)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_container, CFragment.newInstance())
                            .commit();
                }
                break;
            default:
                return false;
        }
        return true;
    }
}
