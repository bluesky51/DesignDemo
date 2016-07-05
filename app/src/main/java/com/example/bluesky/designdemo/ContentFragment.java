package com.example.bluesky.designdemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    @BindView(R.id.layout)
    FrameLayout linearLayout;
    @BindView(R.id.recyler)
    RecyclerView recyclerView;
    int pos;

    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, view);
        switch (pos) {
            case 0:
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case 1:
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
        }
        LinearLayoutManager manager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        List<String> list =new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add("==标题=="+i);
        }
        recyclerView.setAdapter(new MyAdapter(list,getActivity()));

        return view;
    }

}
