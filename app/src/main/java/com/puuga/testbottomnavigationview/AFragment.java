package com.puuga.testbottomnavigationview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragment extends Fragment {

    private static final String COUNT = "COUNT";
    private int count = 0;

    public AFragment() {
        // Required empty public constructor
    }

    public static AFragment newInstance() {
        return new AFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNT, count);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(COUNT)+1;
            Log.d("a_count", "count: " + count);
        }
    }
}
