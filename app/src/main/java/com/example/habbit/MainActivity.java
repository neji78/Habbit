package com.example.habbit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton m_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_add = findViewById(R.id.add);
        m_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddRoutine(v);
            }
        });
    }
    public void openAddRoutine(View view){
        Intent intent = new Intent(this, addRoutine.class);
        startActivity(intent);
    }
}