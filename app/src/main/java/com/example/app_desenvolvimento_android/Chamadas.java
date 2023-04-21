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

    @GET("posts")
    Call<List<Postagens>> getPostagens();

    @GET("comments")
    Call<List<Comentarios>> getComentarios();

    @GET("users")
    Call<List<Usuarios>> getUsuarios();

    @GET("todos")
    Call<List<Todos>> getTodos();

    @GET("posts/{id}")
    Call<Postagens> getPostagensById(@Path("id") String id);

    @GET("comments/{id}")
    Call<Comentarios> getComentariosById(@Path("id") String id);

    @GET("users/{id}")
    Call<Usuarios> getUsuarioById(@Path("id") String id);

    @GET("todos/{id}")
    Call<Todos> getTodosById(@Path("id") String id);
}

