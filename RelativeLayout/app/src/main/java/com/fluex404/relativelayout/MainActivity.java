package com.fluex404.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.r1).setOnClickListener(this);
        findViewById(R.id.r2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.r1:
                Intent i1 = new Intent(MainActivity.this, RelativeLayout1.class);
                startActivity(i1);
                break;
            case R.id.r2:
                Intent i2 = new Intent(MainActivity.this, RelativeLayout2.class);
                startActivity(i2);
                break;
            default: break;
        }
    }
}
