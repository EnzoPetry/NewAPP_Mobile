package com.example.app_desenvolvimento_android.modelos;

public class Todos {
    private int userId;
    private String id;
    private String title;

    public int getUserId() {
        return userId;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Identificação do Usuário: " + userId + "\n" +
                "Titulo: " + title + "\n\n";
    }
}
