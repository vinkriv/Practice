package com.example.vinkriv.practice;

/**
 * Created by vinkriv on 2/22/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OtherApp extends AppCompatActivity {
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_app);
        button2=(Button)findViewById(R.id.button2);

        Toast.makeText(this,getIntent().getStringExtra("TEST"),Toast.LENGTH_SHORT).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendInfoBack=new Intent();
                sendInfoBack.putExtra(MainActivity.SEND_BACK,"Message");
                setResult(RESULT_OK,sendInfoBack);
                finish();
            }
        });

    }

}
