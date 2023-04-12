package com.example.habbit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_view {
    private Context m_context;
    private routine_adaptor m_routine_adapter;
    public adapter_view(Context context) {
        m_context = context;
    }
    public routine_adaptor getAdapter(List<routine_item> routines)
    {
        m_routine_adapter = new routine_adaptor(routines);
        return m_routine_adapter;
    }

    private class routine_adaptor extends RecyclerView.Adapter<routine_holder>{
        private List<routine_item> mRoutines;
        public routine_adaptor(List<routine_item> routines ) {
            mRoutines = routines;
        }

        @Override
        public routine_holder onCreateViewHolder( ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(m_context);
            return new routine_holder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull routine_holder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mRoutines.size();
        }
    }
    private class routine_holder extends RecyclerView.ViewHolder {

        public routine_holder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.routine_list,parent,false));
        }
    }
}

