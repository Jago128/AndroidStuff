package com.example.miperfilviajero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tbName;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private CheckBox cb1;
    private CheckBox cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup rbGroup = findViewById(R.id.rbGroup);
        rb1 = findViewById(R.id.rb1);
        rb1.setSelected(true);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        Button btn1 = findViewById(R.id.btn1);
        tbName = findViewById(R.id.tbName);
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        TextView tvCb = findViewById(R.id.tvCb1);
        TextView tvRb = findViewById(R.id.tvRb);
        TextView tvPrompt = findViewById(R.id.tvPrompt);
        TextView tvSubtitle = findViewById(R.id.tvSubtitle);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvName = findViewById(R.id.tvName);
        btn1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String name;
        boolean beach = false, mount = false, city = false, bp = false, photo = false;

        name = String.valueOf(tbName.getText());

        if (name.isBlank()) {
            Toast.makeText(this, "El nombre no puede esta vacio.", Toast.LENGTH_SHORT).show();
        } else {
            if (rb1.isSelected()) {
                beach = true;
            } else if (rb2.isSelected()) {
                mount = true;
            } else if (rb3.isSelected()) {
                city = true;
            }

            if (cb1.isSelected()) {
                bp = true;
            }

            if (cb2.isSelected()) {
                photo = true;
            }

            //Opening of 2nd activity
        }
    }
}