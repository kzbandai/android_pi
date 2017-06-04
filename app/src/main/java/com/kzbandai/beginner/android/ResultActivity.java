package com.kzbandai.beginner.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle results = intent.getExtras();
        String result_text = results.getString(MainActivity.extraWithResultActivity);

        TextView Result = (TextView) findViewById(R.id.result_value);
        Result.setText(result_text, TextView.BufferType.NORMAL);
    }
}
