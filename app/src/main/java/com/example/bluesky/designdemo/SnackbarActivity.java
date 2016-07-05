package com.example.bluesky.designdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnackbarActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button btn;


    @BindView(R.id.button2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void show(View view) {
        Snackbar.make(view, "提示框", 1000).show();
    }

    @OnClick(R.id.button2)
    public void show2(View view) {
        Snackbar.make(view, "提示框", 1000).setActionTextColor(Color.BLUE).

                setAction("点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("====","+====");
                        btn2.setText("你好");

                    }
                }).setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                Log.e("====","+==onDismissed==");
            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                Log.e("====","+==onShown==");
            }
        }).show();
    }
}
