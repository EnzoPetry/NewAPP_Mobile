package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app_desenvolvimento_android.modelos.Comentarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActComments extends AppCompatActivity {

    private TextView textView;
    private EditText idComentarios;

    private API api;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setText("");
            String id = idComentarios.getText().toString();
            api.getComentariosById(id,new Callback<Comentarios>() {
                @Override
                public void onResponse(Call<Comentarios> call, Response<Comentarios> response) {
                    if (!response.isSuccessful()) {
                        textView.setText("codigo: " + response.code());
                        return;
                    }
                    Comentarios comentario = response.body();

                    String content = "";
                    content += comentario.toString();
                    textView.append(content);

                }

                @Override
                public void onFailure(Call<Comentarios> call, Throwable t) {
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
        setContentView(R.layout.activity_comments);

        textView = findViewById(R.id.textView);
        idComentarios = findViewById(R.id.idComentarios);
        api = new API();

        Button buscaInfo = findViewById(R.id.buscaInfo);
        idComentarios.addTextChangedListener(textWatcher);
        buscaInfo.setOnClickListener(v -> api.getComentarios(new Callback<List<Comentarios>>() {
            @Override
            public void onResponse(Call<List<Comentarios>> call, Response<List<Comentarios>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("codigo: " + response.code());
                    return;
                }
                List<Comentarios> listaComentarios = response.body();
                textView.setText("");
                for (Comentarios comentario : listaComentarios) {
                    String content = "";
                    content += comentario.toString();
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comentarios>> call, Throwable t) {
                textView.setText(t.getMessage());

            }

        }));

    }
}