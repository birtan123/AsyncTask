package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstActivity extends AppCompatActivity implements LoaderListener{

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);


        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaderAsyncTask as = new LoaderAsyncTask(getSupportFragmentManager(),FirstActivity.this);
                as.execute(Integer.parseInt(editText.getText().toString()));
            }
        });

    }
    @Override
    public void Res(String res) {
textView.setText(res);
textView.setTextColor(Color.GREEN);
    }
}


