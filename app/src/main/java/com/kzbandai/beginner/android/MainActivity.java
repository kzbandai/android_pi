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
                Intent intent = new Intent();
                intent.setClassName(getPackageName(), ResultActivity.class.toString());

                EditText resultEditText = (EditText) findViewById(R.id.targetNumber);
                String targetNumber = resultEditText.getText().toString();
                intent.putExtra(extraWithResultActivity, targetNumber);

                startActivity(intent);
            }
        });
    }

    private String searchResult(String targetNumber) {
        String searchResult = String.valueOf(pi().indexOf(targetNumber));
        if (searchResult.equals("-1")) {
            return "ないよ";
        }

        return String.valueOf(pi().indexOf(targetNumber));
    }

    private String pi() {
        Double a = Math.pow(10, 10000);
        Double b = Math.pow(10, 10000);
        Integer i = 10000 * 8 + 1;

        while (i > 3) {
            a = (a + b + b) * (i / 2) / i;
            i = i - 2;
        }

        return String.valueOf(a - b);
    }
}
