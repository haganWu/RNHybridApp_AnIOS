package com.csco.android;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private EditText input, paramInput;
    private final int TYPE_MODEL_FIRST = 0x1111;
    private final int TYPE_MODEL_SECOND = 0x1112;
    private int typeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        paramInput = findViewById(R.id.paramInput);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.mode1) {
                    typeModel = TYPE_MODEL_FIRST;
                } else if (checkedId == R.id.mode2) {
                    typeModel = TYPE_MODEL_SECOND;
                }
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.jump) {
            doJump();
        }
    }

    private void doJump() {
        String moduleName = input.getText().toString().trim();
        String inputParams = paramInput.getText().toString().trim();
        if (typeModel == TYPE_MODEL_FIRST) {
            RNPageActivity.start(this, moduleName, inputParams);
        } else if (typeModel == TYPE_MODEL_SECOND) {
            ReactPageActivity.start(this, moduleName, inputParams);
        }
    }
}