package com.example.mypersonal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewButton;
    private TextView namaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Inisialisasi
        textViewButton = findViewById(R.id.textViewButton);
        namaTextView = findViewById(R.id.nama);

        // Ambil nama dari intent
        String nama = getIntent().getStringExtra("NAMA");
        namaTextView.setText(nama);

        // Inisialisasi
        ImageButton imageBtnMove = findViewById(R.id.btnMove);
        ImageButton imageBtnShare = findViewById(R.id.btnShare);
        ImageButton imageBtnTelp = findViewById(R.id.btnTelp);
        ImageButton imageBtnSend = findViewById(R.id.btnSend);


        textViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });


        imageBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit Intent untuk berbagi ke media sosial
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo, saya suka dengan Ilham Muzadid");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Share to:"));
            }
        });


        imageBtnTelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mulai aktivitas dialer
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:085712744961")); // Telepon saya
                startActivity(callIntent);
            }
        });


        imageBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");

                // Menambahkan informasi email
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ilhammuzadid@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Email");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Isi pesan email di sini.");

                // Menentukan aplikasi Gmail secara spesifik
                emailIntent.setPackage("com.google.android.gm");

                try {
                    startActivity(emailIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SecondActivity.this, "Aplikasi Gmail tidak ditemukan.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Set OnClickListener untuk tombol Move
        imageBtnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk menunjukkan alamat di peta
                Uri gmmIntentUri = Uri.parse("https://maps.app.goo.gl/b23CezWcbth5U7Xr9"); // Lokasi Anda
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Memastikan ada aplikasi yang dapat menangani intent ini
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    // Tampilkan pesan jika tidak ada aplikasi yang dapat menangani intent
                    Toast.makeText(SecondActivity.this, "Tidak ada aplikasi peta yang terpasang.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}