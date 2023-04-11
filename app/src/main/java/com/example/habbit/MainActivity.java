package com.example.habbit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    private ImageButton m_add;
    private ImageButton m_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_add = findViewById(R.id.add);
        m_setting = findViewById(R.id.dropdown_menu);
        m_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddRoutine(v);
            }
        });
        m_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }
    public void openAddRoutine(View view){
        Intent intent = new Intent(this, addRoutine.class);
        startActivity(intent);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.new_routine:
                        openAddRoutine(item.getActionView());
                        return true;
                    case R.id.setting:
//                setting(item);
                        return true;
                    case R.id.exit:
                        closeApp();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }
    public void closeApp(){
        finishAffinity();
        System.exit(0);
    }


}