package com.fluex404.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button changeFrag;
    Boolean kondisi = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFrag = findViewById(R.id.change);
        changeFrag.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.change:

                if(kondisi) {
                    FragSatu f1 = new FragSatu();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    t.replace(R.id.main_menu, f1);
                    t.commit();

                    kondisi = true;
                } else {
                    FragDua f2 = new FragDua();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction t = fm.beginTransaction();
                    t.replace(R.id.main_menu, f2);
                    t.commit();

                    kondisi = true;
                }

                break;
        }
    }
}
