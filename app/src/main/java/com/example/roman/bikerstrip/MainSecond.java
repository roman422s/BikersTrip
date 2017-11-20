package com.example.roman.bikerstrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Roman on 1. 05. 2016.
 */
public class MainSecond extends AppCompatActivity {
    private ApplicationMy app;
    private TextView tvAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (ApplicationMy) getApplication();
        setContentView(R.layout.activity_main_second);
        tvAll = (TextView) findViewById(R.id.tvAllData);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent!=null) {
            String message = intent.getStringExtra(MainActivity.PARAMETER_ACTIVITY_1);
            Snackbar.make(findViewById(R.id.myCoordinatorLayout2), "Shranim podatke:" + message,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
        tvAll.setText(app.getAll().toString());
    }
}
