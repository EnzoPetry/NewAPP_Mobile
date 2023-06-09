package com.example.app_desenvolvimento_android;

import com.example.app_desenvolvimento_android.modelos.Comentarios;
import com.example.app_desenvolvimento_android.modelos.Postagens;
import com.example.app_desenvolvimento_android.modelos.Todos;
import com.example.app_desenvolvimento_android.modelos.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    private Chamadas chamadas;

    public API() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        chamadas = retrofit.create(Chamadas.class);
    }

    public void getPostagensById(String id, Callback<Postagens> callback) {
        Call<Postagens> call = chamadas.getPostagensById(id);
        call.enqueue(callback);

    }
    public void getComentariosById(String id, Callback<Comentarios> callback) {
        Call<Comentarios> call = chamadas.getComentariosById(id);
        call.enqueue(callback);

    }

    public void getUsuarioById(String id, Callback<Usuarios> callback) {
        Call<Usuarios> call = chamadas.getUsuarioById(id);
        call.enqueue(callback);
    }
    public void getTodosById(String id,Callback<Todos>callback) {
        Call<Todos> call = chamadas.getTodosById(id);
        call.enqueue(callback);
    }

    public void getPostagens(Callback<List<Postagens>> callback) {
        Call<List<Postagens>> call = chamadas.getPostagens();
        call.enqueue(callback);

    }
    public void getComentarios(Callback<List<Comentarios>> callback) {
        Call<List<Comentarios>> call = chamadas.getComentarios();
        call.enqueue(callback);

    }
    public void getUsuarios(Callback<List<Usuarios>> callback) {
        Call<List<Usuarios>> call = chamadas.getUsuarios();
        call.enqueue(callback);
    }

    public void getTodos(Callback<List<Todos>> callback) {
        Call<List<Todos>> call = chamadas.getTodos();
        call.enqueue(callback);
    }
}


