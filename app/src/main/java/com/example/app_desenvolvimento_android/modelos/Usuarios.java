package com.example.app_desenvolvimento_android.modelos;

public class Usuarios {
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }
    public String getNome() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Email: " + email + "\n\n";
    }
}
