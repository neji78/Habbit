package com.example.habbit;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class routine_lab {
    private static routine_lab sRoutineLab;
    private ArrayList<routine_item> mRoutines;
    routine_lab() {
        mRoutines = new ArrayList<>();
    }
    public void add_item(routine_item item)
    {
        mRoutines.add(item);
    }
    public List<routine_item> getRoutines() {
        return mRoutines;
    }
    public routine_item getCrime(UUID id) {
        for (routine_item routine : mRoutines) {
            if (routine.getM_id().equals(id)) {
                return routine;
            }
        }
        return null;
    }
}
