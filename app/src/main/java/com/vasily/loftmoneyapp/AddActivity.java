package com.vasily.loftmoneyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {


    public EditText nameInput;
    public EditText priceInput;
    public Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameInput = findViewById(R.id.name);
        priceInput = findViewById(R.id.price);
        addBtn = findViewById(R.id.add_btn);



        TextWatcher watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addBtn.setEnabled(!TextUtils.isEmpty(nameInput.getText()) && !TextUtils.isEmpty(priceInput.getText()));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        nameInput.addTextChangedListener(watcher);

        priceInput.addTextChangedListener(watcher);
    }

  }