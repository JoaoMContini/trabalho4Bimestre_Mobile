package com.example.trabalho4bimestre.model;
public class LoginSenha {
    private int idLoginSenha;
    private String login;
    private String senha;
    private String nome;

    public LoginSenha() {
    }

    //Construtor
    public LoginSenha(int idLoginSenha, String login, String senha, String nome) {
        this.idLoginSenha = idLoginSenha;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
    }


    //Getters And Setters
    public int getIdLoginSenha() {
        return idLoginSenha;
    }

    public void setIdLoginSenha(int idLoginSenha) {
        this.idLoginSenha = idLoginSenha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
