package com.example.bluesky.designdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_textInputLayout)
    Button btn_textInputLayout;
    @BindView(R.id.btn_snackbar)
    Button btn_snackbar;
    @BindView(R.id.btn_floatActionButton)
    Button btn_floatActionButton;
    @BindView(R.id.btn_navigationview)
    Button btn_navigationview;
    @BindView(R.id.btn_collapsingtoolbarLayout)
    Button btn_collapsingtoolbarLayout;
    @BindView(R.id.btn_tabLayout)
    Button btn_tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_textInputLayout)
    public void setBtn_textInputLayout(View view){
         startActivity(new Intent(this,TextInputLayoutActivity.class));
    }
    @OnClick(R.id.btn_snackbar)
    public void setBtn_snackbar(View view){
        startActivity(new Intent(this,SnackbarActivity.class));
    }
    @OnClick(R.id.btn_navigationview)
    public void setBtn_navigationview(View view){
        startActivity(new Intent(this,NavigationViewActivity.class));
    }
    @OnClick(R.id.btn_collapsingtoolbarLayout)
    public void setBtn_collapsingtoolbarLayout(View view){
        startActivity(new Intent(this,CollapsingToolbarLayoutActivity.class));
    }
    @OnClick(R.id.btn_tabLayout)
    public void setBtn_tabLayout(View view){
        startActivity(new Intent(this,TabLayoutActivity.class));
    }
}
