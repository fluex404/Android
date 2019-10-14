package com.fluex404.menukonteks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showMenu = findViewById(R.id.konteks);
        registerForContextMenu(showMenu);
    }

    // method ini digunakan menginit menu yang akan elu gunakan
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contoh_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // method ini digunakan menangani kejadian menu konteks dikelick

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(getApplicationContext(), "Salin", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Hapus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }
}
