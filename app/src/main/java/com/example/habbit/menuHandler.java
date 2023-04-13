package com.example.habbit;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class menuHandler extends PopupMenu {
    private MainActivity m_parent;
    public menuHandler(Context context, View anchor ) {
        super(context, anchor);
        m_parent = (MainActivity) context;
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.main_menu, this.getMenu());
        this.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.new_routine:
                        m_parent.openAddRoutine(item.getActionView());
                        return true;
                    case R.id.setting:
//                setting(item);
                        return true;
                    case R.id.exit:
                        m_parent.closeApp();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

}
