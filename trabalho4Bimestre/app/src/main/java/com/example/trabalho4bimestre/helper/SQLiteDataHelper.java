package com.example.trabalho4bimestre.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataHelper extends SQLiteOpenHelper {
    public SQLiteDataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PRODUTO(IDPRODUTO INTEGER PRIMARY KEY AUTOINCREMENT, DESCRICAO VARCHAR(250), VALOR NUMERIC)");
        sqLiteDatabase.execSQL("CREATE TABLE LOGINSENHA(IDLOGINSENHA INTEGER PRIMARY KEY AUTOINCREMENT, LOGIN VARCHAR(30), SENHA VARCHAR(20), NOME VARCHAR(25))");
        sqLiteDatabase.execSQL("CREATE TABLE PAGAMENTO(IDPAGAMENTO INTEGER PRIMARY KEY AUTOINCREMENT, TIPOPAGAMENTO VARCHAR(100))");
        sqLiteDatabase.execSQL("CREATE TABLE VENDA(IDVENDA INTEGER PRIMARY KEY AUTOINCREMENT, PRODUTO VARCHAR(20), USUARIO VARCHAR(20), PAGAMENTO VARCHAR(20), QUANTIDADE INTEGER, VALORUNITARIO NUMERIC, VALORTOTAL NUMERIC)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int newVersion, int oldVersion) {}
}
