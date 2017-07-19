package com.example.android.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private EditText myET;
    private TextView myTV;
    private SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPrefs = getSharedPreferences("Settings", Context.MODE_PRIVATE);

        myET = (EditText) findViewById(R.id.username_ET);
        myTV = (TextView) findViewById(R.id.myTV);
        Button saveBTN = (Button) findViewById(R.id.save_BTN);
        Button readBTN = (Button) findViewById(R.id.read_BTN);
        saveBTN.setOnClickListener(this);
        readBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_BTN:
                SharedPreferences.Editor editor = myPrefs.edit();
                String userName = myET.getText().toString();
                editor.putString("username", userName);
                editor.apply();
                break;

            case R.id.read_BTN:
                String value = myPrefs.getString("username", "missing");
                myTV.setText(value);
                break;

            default:
                return;
        }
    }
}

