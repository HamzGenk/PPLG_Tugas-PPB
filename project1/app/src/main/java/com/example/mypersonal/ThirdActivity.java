package com.example.mypersonal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private ImageButton imageButtonLove;
    private TextView textViewCount;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        imageButtonLove = findViewById(R.id.imageButtonLove);
        textViewCount = findViewById(R.id.textViewCount);

        imageButtonLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textViewCount.setText(String.valueOf(count));
            }
        });
    }
}