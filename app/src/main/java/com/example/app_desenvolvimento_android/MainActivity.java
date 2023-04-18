package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botaoTela = findViewById(R.id.trocar_activity);
        botaoTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tela2.class);
                startActivity(intent);
            }
        });

        Button botaoConfig = findViewById(R.id.configuracoes);
        botaoConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente a lógica para abrir a Activity de configurações aqui
            }
        });
    }
}