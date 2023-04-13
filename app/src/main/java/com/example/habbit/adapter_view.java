package com.example.habbit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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
        public void onBindViewHolder( routine_holder holder, int position) {
            routine_item item = mRoutines.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return mRoutines.size();
        }
    }
    private class routine_holder extends RecyclerView.ViewHolder {

        private TextView m_routineName;
        private TextView m_routineDescription;
        private routine_item m_routine;
        private TableLayout m_table;
        public routine_holder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.routine_list,parent,false));
            m_routineName = (TextView) itemView.findViewById(R.id.routine_name);
            m_routineDescription = (TextView) itemView.findViewById(R.id.routine_description);
            m_table = (TableLayout) itemView.findViewById(R.id.table_row);
            m_table.addView(new table_row_(m_context, 7));
        }
        public void bind(routine_item crime) {
            m_routine = crime;
            m_routineName.setText(m_routine.getM_routine_name());
            m_routineDescription.setText(m_routine.getM_routine_description());
        }
    }
}

