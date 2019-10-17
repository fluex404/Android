package com.fluex404.internalexternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button internal, external;
    private EditText inputData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData = findViewById(R.id.input_data);
        internal = findViewById(R.id.save_internal);
        external = findViewById(R.id.save_external);

        internal.setOnClickListener(this);
        external.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.save_internal:
                String setData = inputData.getText().toString().trim();
                //Digunakan untuk membuat dan menulis File/Data pada penyimpanan
                FileOutputStream fileOutputStream;
                try{

                    //membuat berkas baru dengan private method
                    fileOutputStream= openFileOutput("DataSaya", MODE_PRIVATE);

                    //menulis data baru dan menkonversi kedalam bentuk byte
                    fileOutputStream.write(setData.getBytes());

                    //menurut fileoutputstream
                    fileOutputStream.close();

                    Toast.makeText(getApplicationContext(), "Data disimpan ke internal", Toast.LENGTH_SHORT).show();

                } catch(IOException e){
                    e.printStackTrace();
                }
                break;


            default:
                break;
        }
    }
}
