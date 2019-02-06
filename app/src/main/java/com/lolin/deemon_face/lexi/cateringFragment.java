package com.lolin.deemon_face.lexi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class cateringFragment extends Fragment {
    private static final String TAG = "cateringFragment";
    private View catersView;
    private RecyclerView caters;


    public cateringFragment(){
        //empty
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        catersView = inflater.inflate (R.layout.cateringfragment,container,false);

        caters = catersView.findViewById (R.id.catering_recyclerView);
        caters.setLayoutManager (new LinearLayoutManager(getContext ()));

        return catersView;
    }
}
