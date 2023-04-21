package com.example.app_desenvolvimento_android.modelos;

public class Comentarios {
    private int postId;
    private String id;
    private String name;
    private String email;
    private String body;

    public int getPostId() {
        return postId;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getBody() {
        return body;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Identificação do Post: " + postId + "\n" +
                "Nome: " + name + "\n" +
                "E-mail: " + email + "\n" +
                "Corpo: " + body + "\n\n";
    }
}
