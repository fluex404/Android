package com.fluex404.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * DIBUAT OLEH ISA
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView dataInput;
    private Button sendIntent, sendBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataInput = findViewById(R.id.input);
        sendIntent = findViewById(R.id.send_by_intent);
        sendBundle = findViewById(R.id.send_by_bundle);

        sendIntent.setOnClickListener(this);
        sendBundle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.send_by_intent:
                // mengirim/passing data menggunakan intent
                Intent sendData1 = new Intent(MainActivity.this, SecondActivity.class);
                sendData1.putExtra("DATA_SAYA", dataInput.getText().toString());
                startActivity(sendData1);
                break;
            case R.id.send_by_bundle:
                // mengirim/passing data menggunakan bundle
                Bundle setData = new Bundle();
                Intent sendData2 = new Intent(MainActivity.this, SecondActivity.class);
                setData.putString("DATA_SAYA", dataInput.getText().toString());
                sendData2.putExtras(setData);
                startActivity(sendData2);
                break;
        }
    }
}
