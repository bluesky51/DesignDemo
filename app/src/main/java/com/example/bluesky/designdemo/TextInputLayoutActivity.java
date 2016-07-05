package com.example.bluesky.designdemo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TextInputLayoutActivity extends AppCompatActivity {

    @BindView(R.id.textInputLayout_name)
    TextInputLayout textInputLayoutName;
    @BindView(R.id.et_inputName)
    EditText editTextName;
    @BindView(R.id.textInputLayout_pwd)
    TextInputLayout textInputLayoutPwd;
    @BindView(R.id.et_inputPwd)
    EditText editTextPwd;
    @BindView(R.id.login_toolBar)
    Toolbar toolbar;

    @BindView(R.id.btn_login)
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_view);
        setSupportActionBar(toolbar);
        textInputLayoutName.setHint("请输入用户名");
        textInputLayoutPwd.setHint("请输入密码");
        textInputLayoutName.setCounterEnabled(true);
        textInputLayoutPwd.setCounterEnabled(true);
        textInputLayoutName.setCounterMaxLength(12);
        textInputLayoutPwd.setCounterMaxLength(6);

        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String name = editTextName.getText().toString();
                if (name.length() < 6) {
                    textInputLayoutName.setErrorEnabled(true);
                    textInputLayoutName.setError("用户名错误,请重新输入");
                }else{
                    textInputLayoutName.setErrorEnabled(false);
                }
            }
        });
        editTextPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String pwd = editTextPwd.getText().toString();
                if (pwd.length() < 6) {

                    textInputLayoutPwd.setErrorEnabled(true);
                    textInputLayoutPwd.setError("密码错误，请重新输入");
                }else{
                    textInputLayoutPwd.setErrorEnabled(false);
                }
            }
        });
    }

    @OnClick(R.id.btn_login)
    public void Login(View view) {
        String name = editTextName.getText().toString();
        String pwd = editTextPwd.getText().toString();

    }
}
