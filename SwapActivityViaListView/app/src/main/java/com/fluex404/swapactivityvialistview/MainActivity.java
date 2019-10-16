package com.fluex404.swapactivityvialistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private String[] mahasiswa = {"Isa", "Taufan", "Ilham"};

    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listitem);
        data = new ArrayList<>();
        getData();

        //ArrayAdapter digunakan untuk mengatur, bagaimana item pada ListView akan tampil
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);
        listView.setAdapter(adapter);

        // Menambahkan Listener, untuk menangani kejadian salah satu item diklik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Mendapatkan Nama pada salah satu item yang diklik, yang berdasarkan posisinya
                String getName = data.get(position);

                // Berpindah Activity dan mempassing data Nama pada Activity Selanjutnya
                Intent sendData = new Intent(MainActivity.this, DataMahasiswa.class);
                sendData.putExtra("MyName", getName);
                startActivity(sendData);
            }
        });
    }

    private void getData(){
        // Memasukan Semua Data Mahasiswa kedalam ArrayList
        Collections.addAll(data, mahasiswa);
    }
}
