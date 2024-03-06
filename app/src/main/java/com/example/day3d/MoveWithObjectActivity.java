package com.example.day3d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String KEY_DATA = "key_object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvType = findViewById(R.id.tvType);
        TextView tvAge = findViewById(R.id.tvAge);

        Marvel marvel;
        if (Build.VERSION.SDK_INT >= 33) {
            marvel = getIntent().getParcelableExtra(KEY_DATA, Marvel.class);
        } else {
            marvel = getIntent().getParcelableExtra(KEY_DATA);
        }

        tvName.setText(marvel.getName());
        tvAge.setText(String.valueOf(marvel.getAge()));
        tvType.setText(marvel.getType());
    }
}