package com.example.bluesky.designdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    //1.提供一个可折叠的toolbar继承自FrameLayout,
    //2.可以通过设置layout_scrollFlags,
    //3. 让包含在CollapsingToolbarLayout中的控件(如：ImageView、Toolbar)
    // 在响应layout_behavior事件时作出相应的scrollFlags滚动事件(移除屏幕或固定在屏幕顶端)。

    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    CoordinatorLayout  coordinatorLayout;
    @BindView(R.id.floatingbtn)
    FloatingActionButton  floatingbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        ButterKnife.bind(this);
        //toolbar.setNavigationIcon(android.R.drawable.ic_menu_view);
        setSupportActionBar(toolbar);


        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，
        // 设置到Toolbar上则不会显示

        collapsingToolbarLayout.setTitle("折叠效果");
        //通过CollapsingToolbarLayout修改字体颜色
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.aa);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.aa);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);

        List<String> list =new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("==标题=="+i);
        }
        recyclerView.setAdapter(new MyAdapter(list,this));

        floatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"你好",1000).show();
            }
        });
    }

}
