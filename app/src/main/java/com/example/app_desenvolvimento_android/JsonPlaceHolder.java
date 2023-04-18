package com.example.app_desenvolvimento_android;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolder {
    @GET("users/")
    Call<List<Usuarios>> getUsuarios();
}
