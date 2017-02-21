package com.example.jmajyo.cardtrick.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jmajyo.cardtrick.R;

public class ChangeIPActivity extends AppCompatActivity {
    private Button save;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_ip);
        save = (Button) findViewById(R.id.activity_change_ip___button);
        text = (EditText) findViewById(R.id.activity_change_ip___text);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                String ip = text.getText().toString();
                returnIntent.putExtra("IP",ip);
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
