package com.fluex404.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView hasil;
    private EditText masukan;
    private Button eksekusi;

    // deklarasi dan inisialisasi sharedpreferences
    private SharedPreferences preferences;

    // digunakan untuk konfigurasi sharedpreferences
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masukan = findViewById(R.id.input);
        hasil = findViewById(R.id.output);
        eksekusi = findViewById(R.id.save);

//        preferences = getSharedPreferences("belajar_sharedpreferences", Context.MODE_PRIVATE);

        preferences = MainActivity.this.getSharedPreferences("belajar_sharedpasdlfjladsjf", Context.MODE_PRIVATE);

        eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getData(){
        // mendapatkan input dari user
        String getKonten = masukan.getText().toString();

        // digunakakn untuk mengatur konfigurasi sharedpreferences
        editor = preferences.edit();

        // memasukan data pada Editor SharedPreferences dengan key(data saya)
        editor.putString("data_saya", getKonten);

        editor.apply();

        // menampilkan output
        hasil.setText("Output Data : "+preferences.getString("data_saya", null));
    }
}
