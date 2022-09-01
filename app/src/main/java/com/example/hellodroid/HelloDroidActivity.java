package com.example.hellodroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HelloDroidActivity extends AppCompatActivity {
    private TextView message;
    private TextView statusText;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.clickCounter);
        statusText = findViewById(R.id.text_status);
        ImageView droid = findViewById(R.id.droidImage);
        Button buttonRead = findViewById(R.id.button_read);
        Button buttonSimulate = findViewById(R.id.button_simulate);
        //Define and attach click listener
        droid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDroid();
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapRead();
            }
        });

        buttonSimulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapSimulate();
            }
        });
    }

    private void tapRead(){
        statusText.setText("Reading");
    }

    private void tapSimulate(){
        statusText.setText("Simulating");
    }
    private void tapDroid() {
        statusText.setText("");
        counter++;
        String countAsText;
        /*
         * In real applications you should not write switch like the one below.
         * Use resource of type "Quantity strings (plurals)" instead.
         * See https://developer.android.com/guide/topics/resources/string-resource#Plurals
         */
        switch (counter) {
            case 1:
                countAsText = "once";
                break;
            case 2:
                countAsText = "twice";
                break;
            default:
                countAsText = String.format("%d times", counter);
        }
        message.setText(String.format("You touched Ame %s", countAsText));
    }
}