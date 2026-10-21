package com.example.devicemanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private RadioGroup rgType;
    private CheckBox cbBluetooth, cb5G;
    private Button btnCreate;
    private LinearLayout llDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        rgType = findViewById(R.id.rgType);
        cbBluetooth = findViewById(R.id.cbBluetooth);
        cb5G = findViewById(R.id.cb5G);
        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
        llDevices = findViewById(R.id.llDevices);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void addDevice() {
        String name = etName.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "Write a name", Toast.LENGTH_SHORT).show();
            return;
        }

        int checkedId = rgType.getCheckedRadioButtonId();
        RadioButton rb = null;
        if (checkedId != -1) {
            rb = findViewById(checkedId);
        }

        String type;
        if (rb != null) {
            type = rb.getText().toString();
        } else {
            type = "Unknown";
        }

        boolean bluetooth = cbBluetooth.isChecked(), fiveG = cb5G.isChecked();
        Device device = new Device(name, type, bluetooth, fiveG);

        TextView tv = new TextView(this);
        tv.setText(device.describe());
        llDevices.addView(tv);

        etName.setText("");
        rgType.clearCheck();
        cbBluetooth.setChecked(false);
        cb5G.setChecked(false);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCreate) {
            addDevice();
        }
    }
}