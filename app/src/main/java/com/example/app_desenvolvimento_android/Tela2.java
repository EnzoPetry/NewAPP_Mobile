package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app_desenvolvimento_android.modelos.Usuarios;

import java.util.List;

import retrofit2.Call;

public class Tela2 extends AppCompatActivity {
    private TextView textView;
    private EditText idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        textView = findViewById(R.id.textView);
        idUsuario = findViewById(R.id.idUsuario);

        Button buscaInfo = findViewById(R.id.buscaInfo);
        buscaInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente a lógica para abrir a Activity de configurações aqui
                getUsuarios();
            }

        });
    }
    private void getUsuarios() {


        Chamadas JsonPH = retrofit.create(Chamadas.class);
        Call<List<Usuarios>> call = JsonPH.getUsuarios();
        call.enqueue(new () {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("codigo: " + response.code());
                    return;
                }
                List<Usuarios> listaUsuarios = response.body();
                for (Usuarios usuario : listaUsuarios) {
                    String content = "";
                    content += usuario.toString();
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, Throwable t) {
                textView.setText(t.getMessage());

            }
        });

    }

}