package com.maxima.maximaapp.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.service.CountService;
import com.maxima.maximaapp.utils.CountListener;
import com.maxima.maximaapp.view.fragment.ExibirCountFragment;

public class ServiceActivity extends AppCompatActivity implements ServiceConnection {

    private ServiceConnection connection;
    private CountListener countListener;
    private Toolbar toolbarMain;
    private ExibirCountFragment exibirCountFragment;
    private CountService.Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        this.toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        connection = this;
        bindService(new Intent(ServiceActivity.this, CountService.class), connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
         controller = (CountService.Controller) iBinder;
        countListener = controller.getCount();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        controller = null;
    }

    public void start(View view) {

        Toast.makeText(this, "Serviço iniciado", Toast.LENGTH_LONG).show();
        startService(new Intent(ServiceActivity.this, CountService.class));
        if (exibirCountFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(exibirCountFragment)
                    .commit();
        }

    }

    public void stop(View view) {
        stopService(new Intent(ServiceActivity.this, CountService.class));
            int contador = countListener.getCount();
            if(contador != 0) {
                Bundle dados = new Bundle();
                dados.putString("count", String.valueOf(contador));


                exibirCountFragment = new ExibirCountFragment();
                exibirCountFragment.setArguments(dados);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_show, exibirCountFragment)
                        .commit();
            }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(ServiceActivity.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
