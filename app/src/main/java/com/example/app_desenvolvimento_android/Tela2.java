package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app_desenvolvimento_android.modelos.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tela2 extends AppCompatActivity {
    private TextView textView;
    private EditText idUsuario;

    private API api;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setText("");
            String id = idUsuario.getText().toString();
            api.getUsuarioById(id,new Callback<Usuarios>() {
                @Override
                public void onResponse(Call<Usuarios> call, Response<Usuarios> response) {
                    if (!response.isSuccessful()) {
                        textView.setText("codigo: " + response.code());
                        return;
                    }
                    Usuarios usuario = response.body();

                        String content = "";
                        content += usuario.toString();
                        textView.append(content);

                }

                @Override
                public void onFailure(Call<Usuarios> call, Throwable t) {
                }
            });
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        textView = findViewById(R.id.textView);
        idUsuario = findViewById(R.id.idUsuario);
        api = new API();

        Button buscaInfo = findViewById(R.id.buscaInfo);
        idUsuario.addTextChangedListener(textWatcher);
        buscaInfo.setOnClickListener(v -> api.getUsuarios(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("codigo: " + response.code());
                    return;
                }
                List<Usuarios> listaUsuarios = response.body();
                textView.setText("");
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

        }));

    }
}
