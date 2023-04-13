package com.example.habbit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton m_add;
    private ImageButton m_setting;
    private RecyclerView m_routine_list;
    private adapter_view m_adapterView;
    private menuHandler m_menu;
    private LayoutInflater m_layoutInflater;
    private ViewPager m_page;
    private routine_lab m_lab;
    private TableRow table_row_date;
    private TableLayout tableLayout_date;
    private static final String TAG = "TasksSample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_add = findViewById(R.id.add);
        m_setting = findViewById(R.id.dropdown_menu);
        tableLayout_date = findViewById(R.id.table_date);
        m_menu = new menuHandler(this,m_setting);
        m_lab = new routine_lab();
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
    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            if(resultCode == 2) {
                routine_item item_routine = (routine_item) data.getSerializableExtra("key");
                m_lab.add_item(item_routine);
                updateUI();
            }
        }
    }
    public void openAddRoutine(View view){
        Intent intent = new Intent(getApplicationContext(), addRoutine.class);
        startActivityForResult(intent,2);
    }
    public void closeApp(){
        finishAffinity();
        System.exit(0);
    }


    public void updateUI(){
        Log.d(TAG, String.valueOf(m_lab.getRoutines().size()));
        m_adapterView = new adapter_view(getApplicationContext());
        m_routine_list.setAdapter(m_adapterView.getAdapter(m_lab.getRoutines()));
    }
    public void init()
    {
        table_row_date = new TableRow(this);
        for(int i = 0;i < 7;i++)
        {
            TextView textView = new TextView(this);
            textView.setText(dayNameBy(i));
            table_row_date.addView(textView);
        }
        tableLayout_date.addView(table_row_date);
    }
    public String dayNameBy(int i)
    {
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };

        String day = days[calendar.get(Calendar.DAY_OF_WEEK + i)];
        return day;
    }


}