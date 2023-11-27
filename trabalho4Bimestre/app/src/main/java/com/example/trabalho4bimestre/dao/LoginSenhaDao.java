package com.example.trabalho4bimestre.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabalho4bimestre.helper.SQLiteDataHelper;
import com.example.trabalho4bimestre.model.LoginSenha;

import java.util.ArrayList;

public class LoginSenhaDao implements IGenericDao<LoginSenha>{

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private String[] coluna = {"IDLOGINSENHA", "LOGIN", "SENHA", "NOME"};
    private String tabela = "LOGINSENHA";
    private Context context;
    private static LoginSenhaDao instancia;

    public static LoginSenhaDao getInstancia(Context context){
        if (instancia == null){
            return instancia = new LoginSenhaDao(context);
        }else {
            return instancia;
        }
    }

    public LoginSenhaDao(Context context){
        this.context = context;

        openHelper = new SQLiteDataHelper(this.context, "TRABDB", null, 1);

        database = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(LoginSenha obj) {
        try{
            ContentValues valores = new ContentValues();
            valores.put(coluna[1], obj.getLogin());
            valores.put(coluna[2], obj.getSenha());
            valores.put(coluna[3], obj.getNome());

            return database.insert(tabela, null, valores);
        }catch (SQLException ex){
            Log.e("TRABALHO", "ERRO: LoginSenha.insert() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public long update(LoginSenha obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(coluna[1], obj.getLogin());
            valores.put(coluna[2], obj.getSenha());
            valores.put(coluna[3], obj.getNome());
            String[] identificador = {String.valueOf(obj.getIdLoginSenha())};

            return database.update(tabela, valores, coluna[0] + "= ?", identificador);

        } catch (SQLException ex) {
            Log.e("TRABALHO", "ERRO: LoginSenha.update() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(LoginSenha obj) {
        try {
            String[]identificador = {String.valueOf(obj.getIdLoginSenha())};
            return database.delete(tabela,coluna[0]+"=?",identificador);
        }catch (SQLException ex){
            Log.e("TRABALHO", "ERRO: LoginSenha.delete() "+ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<LoginSenha> getAll() {
        ArrayList<LoginSenha> lista = new ArrayList<>();
        try{
            Cursor cursor = database.query(tabela, coluna, null, null, null, null,coluna[0]+"desc");
            if (cursor.moveToFirst()){
                do{
                    LoginSenha loginsenha = new LoginSenha();
                    loginsenha.setIdLoginSenha(cursor.getInt(0));
                    loginsenha.setLogin(cursor.getString(1));
                    loginsenha.setSenha(cursor.getString(2));
                    loginsenha.setNome(cursor.getString(3));

                    lista.add(loginsenha);
                }while (cursor.moveToNext());
            }
        }catch (SQLException ex){
            Log.e("TRABALHO", "ERRO: LoginSenha.getAll() "+ex.getMessage());
        }
        return lista;
    }

    @Override
    public LoginSenha getById(int id) {
        try{
            String[]identficador = {String.valueOf(id)};
            Cursor cursor = database.query(tabela, coluna, coluna[0]+"=?", identficador, null, null, null);

            if (cursor.moveToFirst()){
                    LoginSenha loginsenha = new LoginSenha();
                    loginsenha.setIdLoginSenha(cursor.getInt(0));
                    loginsenha.setLogin(cursor.getString(1));
                    loginsenha.setSenha(cursor.getString(2));
                    loginsenha.setNome(cursor.getString(3));

                return loginsenha;
            }
        }catch (SQLException ex){
            Log.e("TRABALHO", "ERRO: LoginSenha.getById() "+ex.getMessage());
        }
        return null;
        }


    public LoginSenha getByLogin(String login) {
        try{
            String[]identficador = {String.valueOf(login)};
            Cursor cursor = database.query(tabela, coluna, coluna[1]+"=?", identficador, null, null, null);

            if (cursor.moveToFirst()){
                LoginSenha loginsenha = new LoginSenha();
                loginsenha.setIdLoginSenha(cursor.getInt(0));
                loginsenha.setLogin(cursor.getString(1));
                loginsenha.setSenha(cursor.getString(2));
                loginsenha.setNome(cursor.getString(3));

                return loginsenha;
            }
        }catch (SQLException ex){
            Log.e("TRABALHO", "ERRO: LoginSenha.getById() "+ex.getMessage());
        }
        return null;
    }
    }

