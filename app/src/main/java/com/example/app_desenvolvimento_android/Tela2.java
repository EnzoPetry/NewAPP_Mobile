package com.example.app_desenvolvimento_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Tela2 extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);

        textView = findViewById(R.id.textView);
        getUsuarios();
    }
    private void getUsuarios(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        JsonPlaceHolder JsonPH = retrofit.create(JsonPlaceHolder.class);
        Call<List<Usuarios>> call = JsonPH.getUsuarios();
        call.enqueue(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                if(!response.isSuccessful()){
                    textView.setText("codigo: " + response.code());
                    return;
                }
                List<Usuarios> listaUsuarios = response.body();
                for(Usuarios usuario: listaUsuarios){
                    String content = "";
                    content += "Id:" + usuario.getId() + "\n";
                    content += "Nome:" + usuario.getNome() + "\n";
                    content += "Email:" + usuario.getEmail() + "\n";
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