package com.mainor.fact;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())){
                    editText.setError("Please enter a number and try Again!");
                    editText.setFocusable(true);
                }
                else {
                    int num = Integer.parseInt(editText.getText().toString());
                    textView.setText(" " + String.format(Locale.getDefault(), "%.0f", factorial(num)));
                }
            }


        });

    }

    private double factorial(double num) {
        if (num < 2){
            return 1;
        }
        else {
            return num * factorial(num - 1);
        }
    }
}