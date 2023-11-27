package com.example.trabalho4bimestre.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.trabalho4bimestre.dao.LoginSenhaDao;
import com.example.trabalho4bimestre.model.LoginSenha;
import com.example.trabalho4bimestre.view.LoginSenhaActivity;

public class LoginSenhaController {
private Context context;

    public LoginSenhaController(Context context) {
        this.context = context;
    }

    public String salvarLoginSenha(String login, String senha, String nome){
        try{
            if (login.equals("") || login.isEmpty()){
                return "Informe o Login!!";
            }
            if (senha.equals("") || senha.isEmpty()){
                return "Informe a Senha!!";
            }
            if (nome.equals("") || nome.isEmpty()){
                return "Informe o Nome!!";
            }

            LoginSenha loginsenha = LoginSenhaDao.getInstancia(context).getByLogin(login);

            if (loginsenha != null){
                return "O Login ("+login+") já está cadastrado";
            }else{

                loginsenha = new LoginSenha();
                loginsenha.setLogin(login);
                loginsenha.setSenha(senha);
                loginsenha.setNome(nome);

                LoginSenhaDao.getInstancia(context).insert(loginsenha);
            }
        }catch (Exception ex){
            return "Erro ao criar login e senha!";
        }
        return null;
    }


}

