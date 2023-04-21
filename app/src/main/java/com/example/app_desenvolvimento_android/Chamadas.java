package com.example.app_desenvolvimento_android;


import com.example.app_desenvolvimento_android.modelos.Comentarios;
import com.example.app_desenvolvimento_android.modelos.Postagens;
import com.example.app_desenvolvimento_android.modelos.Todos;
import com.example.app_desenvolvimento_android.modelos.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface Chamadas {

    @GET("posts/{id}")
    Call<Postagens> getPostagensById(@Path("id") int id);

    @GET("comments/{id}")
    Call<Comentarios> getComentariosById(@Path("id") int id);

    @GET("users")
    Call<List<Usuarios>> getUsuarios();

    @GET("users/{id}")
    Call<Usuarios> getUsuarioById(@Path("id") String id);

    @GET("todos/{id}")
    Call<Todos> getTodosById(@Path("id") int id);
}

