package com.fluex404.swapactivityvialistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataMahasiswa extends AppCompatActivity {

    private TextView getNim, getName, getJurusan, getSemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

        getSupportActionBar().setTitle("Data Mahasiswa");
        getNim = findViewById(R.id.getnim);
        getName = findViewById(R.id.getnama);
        getJurusan = findViewById(R.id.getjurusan);
        getSemester = findViewById(R.id.getsemester);

        showData();
    }

    @SuppressWarnings("SetTextI18n")
    private void showData(){
        //Mendapatkan Name Mahasiswa dari Activity sebelumnya
        String name = getIntent().getExtras().getString("MyName");

        //Menentukan identitas yangditampilkan berdasarkan nama yang dipilih
//        {"Isa", "Taufan", "Ilham"}
        switch(name) {
            case "Isa":
                getNim.setText("10101001");
                getSemester.setText("1");
                getJurusan.setText("Sistem Informatika");
                getName.setText("Isa");
                break;
            case "Taufan":
                getNim.setText("1010211");
                getSemester.setText("2");
                getJurusan.setText("Teknik Informatika");
                getName.setText("Taufan");
                break;
            case "Ilham":
                getNim.setText("10431001");
                getSemester.setText("1");
                getJurusan.setText("Sastra Inggris");
                getName.setText("Isa");
                break;
        }
    }
}
