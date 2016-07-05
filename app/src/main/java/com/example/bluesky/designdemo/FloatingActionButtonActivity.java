package com.example.bluesky.designdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FloatingActionButtonActivity extends AppCompatActivity {
    @BindView(R.id.btn_floatActionButton)
    FloatingActionButton floatingActionButton;

    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        ButterKnife.bind(this);
      floatingActionButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             Snackbar snackbar = Snackbar.make(v,"你好",1000);
              snackbar.getView().setBackgroundColor(Color.BLUE);
             TextView tv= (TextView) snackbar.getView().findViewById(R.id.snackbar_text);
              tv.setTextColor(Color.RED);
              snackbar. show();
          }
      });
    }
}
