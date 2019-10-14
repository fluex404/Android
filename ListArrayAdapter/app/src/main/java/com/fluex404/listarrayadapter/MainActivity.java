package com.fluex404.listarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //initialize ArrayList
    private List kontenList = new ArrayList<>();
    //initialize ArrayAdapter
    private ArrayAdapter adapter = null;

    //initialize listview variable
    private ListView listView;

    //initialize support component
    private EditText inputData;
    private Button saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_data);
        inputData = findViewById(R.id.input_data);
        saveData = findViewById(R.id.save_data);

        // setting arrayadapter untuk listview
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, kontenList);
        listView.setAdapter(adapter);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Konten k = new Konten();
                k.setData(inputData.getText().toString().trim());
                adapter.add(k);
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
