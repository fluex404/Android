package com.fluex404.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView getValue = findViewById(R.id.getData);

        // just wanna check
        if(getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            getValue.setText("Data Yang Diterima Adalah "+bundle.getString("DATA_SAYA"));
        } else {
            getValue.setText("Data Yang Diterima Adalah "+getIntent().getStringExtra("DATA_SAYA"));
        }
    }
}
