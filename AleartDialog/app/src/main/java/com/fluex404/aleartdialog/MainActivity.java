package com.fluex404.aleartdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showButtonDialog();
            }
        });

    }

    private void showDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Komfirmasi keluar")
                .setMessage("Anda yakin ingin keluar")
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNeutralButton("Other", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
        .setCancelable(false);
        alert.show();
    }

    private void showButtonDialog() {
        final String[] makanan = {"Mie Ayama", "Bakso", "Ayam Goreng", "Nasi Goreng", "Sate"};
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Pilih Menu Makanan")
                .setIcon(R.drawable.ic_notification)
                .setItems(makanan, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i){
                            case 0:
                                Toast.makeText(getApplicationContext(), "Anda Memesan "+makanan[0], Toast.LENGTH_SHORT).show();
                            case 1:
                                Toast.makeText(getApplicationContext(), "Anda Memesan "+makanan[1], Toast.LENGTH_SHORT).show();
                            case 2:
                                Toast.makeText(getApplicationContext(), "Anda Memesan "+makanan[2], Toast.LENGTH_SHORT).show();
                            case 3:
                                Toast.makeText(getApplicationContext(), "Anda Memesan "+makanan[3], Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                });
        alert.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog();
        }
        return true;
    }
}
