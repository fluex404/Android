package com.fluex404.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showMenu = findViewById(R.id.popup);
        showMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Membuat Instead/object dari PopupMenu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.setOnMenuItemClickListener(MainActivity.this);
                popupMenu.inflate(R.menu.contoh_menu);
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contoh_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.menu1:
                Toast.makeText(getApplicationContext(), "Ayam Goreng", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(), "Mie Rebus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(getApplicationContext(), "Bakso", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu4:
                Toast.makeText(getApplicationContext(), "Mie Ayam", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
