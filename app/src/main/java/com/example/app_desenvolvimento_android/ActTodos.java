package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app_desenvolvimento_android.modelos.Todos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActTodos extends AppCompatActivity {

    private TextView textView;
    private EditText idTodos;

    private API api;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setText("");
            String id = idTodos.getText().toString();
            api.getTodosById(id,new Callback<Todos>() {
                @Override
                public void onResponse(Call<Todos> call, Response<Todos> response) {
                    if (!response.isSuccessful()) {
                        textView.setText("codigo: " + response.code());
                        return;
                    }
                    Todos usuario = response.body();

                    String content = "";
                    content += usuario.toString();
                    textView.append(content);

                }

                @Override
                public void onFailure(Call<Todos> call, Throwable t) {
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
        setContentView(R.layout.activity_todos);

        textView = findViewById(R.id.textView);
        idTodos = findViewById(R.id.idTodos);
        api = new API();

        Button buscaInfo = findViewById(R.id.buscaInfo);
        idTodos.addTextChangedListener(textWatcher);
        buscaInfo.setOnClickListener(v -> api.getTodos(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("codigo: " + response.code());
                    return;
                }
                List<Todos> listaTodos = response.body();
                textView.setText("");
                for (Todos usuario : listaTodos) {
                    String content = "";
                    content += usuario.toString();
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                textView.setText(t.getMessage());

            }

        }));

    }
}