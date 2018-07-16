package com.maxima.maximaapp.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.view.fragment.MainFragment;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private FragmentTransaction fragmentTransaction;

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

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_main, new MainFragment())
                .commit();

    }


}
