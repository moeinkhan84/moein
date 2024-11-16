
package com.example.permission;

import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import android.Manifest;

import androidx.core.app.ActivityCompat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.permission.R;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Granted(Manifest.permission.READ_CONTACTS)) {
                    request();
                } else {
                    Toast.makeText(MainActivity.this, "مجوز داده شده است", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean Granted(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void request() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "مجوز صادر شد!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "مجوز رد شد!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
