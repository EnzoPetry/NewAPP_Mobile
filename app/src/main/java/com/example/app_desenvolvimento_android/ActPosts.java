package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.app_desenvolvimento_android.modelos.Postagens;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActPosts extends AppCompatActivity {

    private TextView textView;
    private EditText idPosts;

    private API api;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setText("");
            String id = idPosts.getText().toString();
            api.getPostagensById(id,new Callback<Postagens>() {
                @Override
                public void onResponse(Call<Postagens> call, Response<Postagens> response) {
                    if (!response.isSuccessful()) {
                        textView.setText("codigo: " + response.code());
                        return;
                    }
                    Postagens usuario = response.body();

                    String content = "";
                    content += usuario.toString();
                    textView.append(content);

                }

                @Override
                public void onFailure(Call<Postagens> call, Throwable t) {
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
        setContentView(R.layout.activity_posts);

        textView = findViewById(R.id.textView);
        idPosts = findViewById(R.id.idPosts);
        api = new API();

        Button buscaInfo = findViewById(R.id.buscaInfo);
        idPosts.addTextChangedListener(textWatcher);
        buscaInfo.setOnClickListener(v -> api.getPostagens(new Callback<List<Postagens>>() {
            @Override
            public void onResponse(Call<List<Postagens>> call, Response<List<Postagens>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("codigo: " + response.code());
                    return;
                }
                List<Postagens> listaPostagens = response.body();
                textView.setText("");
                for (Postagens usuario : listaPostagens) {
                    String content = "";
                    content += usuario.toString();
                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Postagens>> call, Throwable t) {
                textView.setText(t.getMessage());

            }

        }));

    }
}
