package com.maxima.maximaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponent();
    }

    private void inicializarComponent() {
        this.toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle(R.string.app_name);
    }
}
