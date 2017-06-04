package com.kzbandai.beginner.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static String extraWithResultActivity = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login_button = (Button) findViewById(R.id.submit);
        login_button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                EditText resultEditText = (EditText) findViewById(R.id.targetNumber);
                String targetNumber = resultEditText.getText().toString();
                intent.putExtra(extraWithResultActivity, searchResult(targetNumber));

                startActivity(intent);
            }
        });
    }

    private String searchResult(String targetNumber) {
        String searchResult = String.valueOf(String.valueOf(Math.PI).substring(2).indexOf(targetNumber) + 1);
        if (searchResult.equals("0")) {
            return "ないです";
        }

        return searchResult;
    }
}
