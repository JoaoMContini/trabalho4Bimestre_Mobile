package com.example.trabalho4bimestre.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho4bimestre.R;
import com.example.trabalho4bimestre.dao.LoginSenhaDao;
import com.example.trabalho4bimestre.model.LoginSenha;

public class LoginSenhaActivity extends AppCompatActivity {

    private Button btLogar;
    private EditText edLogin;
    private EditText edSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_senha);
        btLogar = findViewById(R.id.btLogar);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Login();
            }
        });



    }

    public void Login(){
        edLogin = findViewById(R.id.edLogin);
        edSenha = findViewById(R.id.edSenha);
        LoginSenha loginsenha = LoginSenhaDao.getInstancia(this).getByLogin(edLogin.getText().toString());
        if (edLogin.getText().toString().equalsIgnoreCase(loginsenha.getLogin()) && edSenha.getText().toString().equalsIgnoreCase(loginsenha.getSenha())){
            abrirMenu();
            }else {
             Toast.makeText(this,"Login ou senha errado, tente novamente.", Toast.LENGTH_LONG).show();
        }
        }


    public void abrirMenu(){
        Intent intent = new Intent(LoginSenhaActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}