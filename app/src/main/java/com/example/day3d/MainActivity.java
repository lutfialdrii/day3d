package com.example.day3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        Button btnMoveActivityWithData = findViewById(R.id.btn_move_activity_data);
        Button btnMoveActivityWithObj = findViewById(R.id.btn_move_activity_object);
        Button btnImplicitIntent = findViewById(R.id.btn_implicit_intent);

        // Listener

        btnMoveActivity.setOnClickListener(this);
        btnMoveActivityWithData.setOnClickListener(this);
        btnMoveActivityWithObj.setOnClickListener(this);
        btnImplicitIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_move_activity) {
            Intent intent = new Intent(this, MoveActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_move_activity_data) {
            Intent intent = new Intent(this, MoveWithData.class);
            intent.putExtra(MoveWithData.KEY_DATA, "Fulan");
            startActivity(intent);
        } else if (v.getId() == R.id.btn_move_activity_object) {
            Marvel marvel = new Marvel();
            marvel.setName("Hulk");
            marvel.setType("Human");
            marvel.setAge(68);

            Intent intent = new Intent(this, MoveWithObjectActivity.class);
            intent.putExtra(MoveWithObjectActivity.KEY_DATA, marvel);
            startActivity(intent);

        } else if (v.getId() == R.id.btn_implicit_intent) {
            String phone = "08121123124";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            startActivity(intent);
        }
    }
}