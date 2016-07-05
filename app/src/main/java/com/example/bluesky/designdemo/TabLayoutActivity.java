package com.example.bluesky.designdemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabLayoutActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;

    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager viewPager;

    @BindView(R.id.btn)
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        List<String> list =new ArrayList<>();
        list.add("首页");
        list.add("分类");
        list.add("我的");

        tabLayout.addTab(tabLayout.newTab().setText(list.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(list.get(2)));

        List<Fragment> fragmentList =new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ContentFragment fr=new ContentFragment();
            Bundle b=new Bundle();
            b.putInt("pos",i);
            fr.setArguments(b);
            fragmentList.add(fr);
        }
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),
                fragmentList,list));
        tabLayout.setupWithViewPager(viewPager);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"hhhhh",1000).show();
            }
        });

    }
}
