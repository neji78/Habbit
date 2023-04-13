package com.example.habbit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;


public class addRoutine extends AppCompatActivity {

    private NumberPicker m_routineTimes;
    private EditText m_routine_name;
    private EditText m_routine_description;
    private ImageButton m_done;
    private ImageButton m_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        m_routineTimes = findViewById(R.id.routine_times);
        m_routine_name = findViewById(R.id.routine_edit);
        m_routine_description = findViewById(R.id.routine_description_edit);
        m_routineTimes.setMinValue(0);
        m_routineTimes.setMaxValue(20);
        m_routineTimes.setEnabled(true);

        m_done = findViewById(R.id.done);
        m_close = findViewById(R.id.close_window);
        m_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close_add_page();
            }
        });
        m_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                routine_item item = new routine_item();
                item.setM_times(m_routineTimes.getValue());
                item.setM_routine_name(String.valueOf(m_routine_name.getText()));
                item.setM_routine_description(String.valueOf(m_routine_description.getText()));
                Intent intent=new Intent();
                intent.putExtra("key",item);
                setResult(2,intent);
                close_add_page();
            }
        });

    }
    public void close_add_page(){
        finish();
    }
}
