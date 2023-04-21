package com.example.app_desenvolvimento_android.modelos;

public class Postagens {
    private int userId;
    private String id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getBody() {
        return body;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Identificação do Usuário: " + userId + "\n" +
                "Titulo: " + title + "\n" +
                "Corpo: " + body + "\n\n";
    }
}
