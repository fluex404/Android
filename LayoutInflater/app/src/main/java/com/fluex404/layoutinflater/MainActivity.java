package com.fluex404.layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout kontenView;
    private View sub1Acitivy, sub2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kontenView = findViewById(R.id.konten_view);

        // take inflater layout
        sub1Acitivy = getLayoutInflater().inflate(R.layout.sub1_activity, kontenView, false);
        sub2Activity = getLayoutInflater().inflate(R.layout.sub2_activity, kontenView, false);

        // show the inflater that make leter
        kontenView.addView(sub1Acitivy);
        kontenView.addView(sub2Activity);
    }
}
