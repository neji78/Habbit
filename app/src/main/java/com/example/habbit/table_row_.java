package com.example.habbit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableRow;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

public class table_row_ extends TableRow {
    private int mNumber;
    private int mWidth;
    private int mHeight;
    private ArrayList<Boolean> m_done;
    public table_row_(Context context,int number) {
        super(context);
        mNumber = number;
        m_done = new ArrayList<>();

//        Activity mainActivity = (Activity)context.getApplicationContext();

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getDisplay().getMetrics(displayMetrics);
        mWidth  = 50;//displayMetrics.widthPixels / number;
        mHeight = 50;//displayMetrics.heightPixels / number;
        int i ;
        for( i = 0; i < number;i++){
            ImageButton button_item = new ImageButton(context);
            button_item.setMinimumWidth(mWidth);
            button_item.setMinimumHeight(mHeight);
            button_item.setImageResource(R.drawable.close_fill0_wght400_grad0_opsz48);
            button_item.setColorFilter(Color.parseColor("#ff0000"));
            m_done.add(false);
            int finalI = i;
            button_item.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(!m_done.get(finalI)) {
                        button_item.setImageResource(R.drawable.done_fill0_wght400_grad0_opsz48);
                        button_item.setColorFilter(Color.parseColor("green"));
                        m_done.set(finalI, true);
                    }else{
                        button_item.setImageResource(R.drawable.close_fill0_wght400_grad0_opsz48);
                        button_item.setColorFilter(Color.parseColor("#ff0000"));
                        m_done.set(finalI, false);
                    }
                }
            });
            this.addView(button_item);
        }
    }
}
