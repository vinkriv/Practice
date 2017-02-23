package com.example.vinkriv.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Spinner spinner;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Button button;
    static int LOAD_CODE=123;
    static String SEND_BACK="send back string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        spinner = (Spinner)findViewById(R.id.spinner);
        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadNewActivity = new Intent(MainActivity.this,OtherApp.class);
                loadNewActivity.putExtra("TEST","THISISATEST");
                startActivityForResult(loadNewActivity,LOAD_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(LOAD_CODE, RESULT_OK, data);

        if((resultCode==RESULT_OK)&&(requestCode==LOAD_CODE)) {
            Toast.makeText(this,data.getStringExtra(SEND_BACK),Toast.LENGTH_SHORT).show();
        }

    }
}
