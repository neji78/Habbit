package com.example.habbit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton m_add;
    private ImageButton m_setting;
    private RecyclerView m_routine_list;
    private adapter_view m_adapterView;
    private menuHandler m_menu;
    private LayoutInflater m_layoutInflater;
    private ViewPager m_page;
    private static final String TAG = "TasksSample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_add = findViewById(R.id.add);
        m_setting = findViewById(R.id.dropdown_menu);
        m_menu = new menuHandler(this,m_setting);
        m_layoutInflater = LayoutInflater.from(getApplicationContext());
        m_routine_list = (RecyclerView) findViewById(R.id.routine_recycler_view_1);
        m_routine_list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        m_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddRoutine(v);
            }
        });
        m_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_menu.show();
            }
        });
        updateUI();
    }
    public void openAddRoutine(View view){
        Intent intent = new Intent(this, addRoutine.class);
        startActivity(intent);
    }
    public void closeApp(){
        finishAffinity();
        System.exit(0);
    }


    public void updateUI(){
        List<routine_item> routines = new ArrayList<routine_item>();
        for(int i = 0 ;i < 50;i++){
            routine_item localRoutine = new routine_item();
            localRoutine.setM_routine_name("routine num #"+ String.valueOf(i));
            localRoutine.setM_routine_description("this all about #" + String.valueOf(i));
            localRoutine.setM_times(i);
            routines.add(localRoutine);
        }
        m_adapterView = new adapter_view(getApplicationContext());
        m_routine_list.setAdapter(m_adapterView.getAdapter(routines));
    }


}