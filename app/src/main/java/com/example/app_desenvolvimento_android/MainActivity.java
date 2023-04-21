package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoTela1 = findViewById(R.id.actUsuarios);
        botaoTela1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActUsers.class);
            startActivity(intent);
        });

        Button botaoTela2 = findViewById(R.id.actComments);
        botaoTela2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActPosts.class);
            startActivity(intent);
        });
        Button botaoTela3 = findViewById(R.id.actPostagens);
        botaoTela3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActTodos.class);
            startActivity(intent);
        });
        Button botaoTela4 = findViewById(R.id.actTodos);
        botaoTela4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActComments.class);
            startActivity(intent);
        });
    }
}