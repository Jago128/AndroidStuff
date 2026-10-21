package com.example.miperfilviajero;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnMap;
    private Button btnSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView tvTitle2 = findViewById(R.id.tvTitle2);
        TextView tvGreet = findViewById(R.id.tvGreet);
        TextView tvIdeal = findViewById(R.id.tvIdeal);
        TextView tvRb = findViewById(R.id.tbRb);
        TextView tvChoice1 = findViewById(R.id.tvChoice1);
        TextView tvCb1 = findViewById(R.id.tvCb1);
        TextView tvChoice2 = findViewById(R.id.tvChoice2);
        TextView tvChoice3 = findViewById(R.id.tvChoice3);
        btnMap = findViewById(R.id.btnMap);
        btnSound = findViewById(R.id.btnSound);

        btnMap.setOnClickListener(this);
        btnSound.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnMap) {
            Intent map = new Intent();
            map.setAction(Intent.ACTION_OPEN_DOCUMENT);
            map.setData(Uri.parse("https://maps.google.com"));
            //Action goes here
        } else if (v.getId() == R.id.btnSound) {

        }
    }
}