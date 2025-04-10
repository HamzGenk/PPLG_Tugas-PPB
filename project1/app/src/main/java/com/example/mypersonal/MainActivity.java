package com.example.mypersonal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNama;
    private EditText inputAlamat;
    private EditText inputEmail;
    private EditText inputNoTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNama = findViewById(R.id.input_nama);
        inputAlamat = findViewById(R.id.input_alamat);
        inputEmail = findViewById(R.id.input_email);
        inputNoTelp = findViewById(R.id.input_no_telp);
        Button buttonNext = findViewById(R.id.button_next1);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAMA", inputNama.getText().toString());
                startActivity(intent);
            }
        });
    }
}