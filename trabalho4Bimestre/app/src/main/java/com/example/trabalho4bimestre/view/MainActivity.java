package com.example.trabalho4bimestre.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho4bimestre.R;
import com.example.trabalho4bimestre.controller.LoginSenhaController;
import com.example.trabalho4bimestre.model.LoginSenha;

public class MainActivity extends AppCompatActivity {

    private Button btLogin;
    private Button btRegistro;

    private EditText edLoginDia;
    private EditText edSenhaDia;
    private EditText edNomeDia;

    private View viewAlert;
    private AlertDialog dialog;
    private LoginSenhaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLogin = findViewById(R.id.btLogin);
        btRegistro = findViewById(R.id.btRegistro);
        controller = new LoginSenhaController(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abirTelaLoginSenha();
            }
        });
        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastro();
            }
        });

    }
    public void abirTelaLoginSenha(){
        Intent intent = new Intent(MainActivity.this, LoginSenhaActivity.class);
        startActivity(intent);
    }

    private void abrirCadastro() {
        viewAlert = getLayoutInflater().inflate(R.layout.dialog_cadastro_usuario, null);

        edLoginDia = viewAlert.findViewById(R.id.edLoginDia);
        edSenhaDia = viewAlert.findViewById(R.id.edSenhaDia);
        edNomeDia = viewAlert.findViewById(R.id.edNomeDia);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cadastro de Usuário");
        builder.setView(viewAlert);
        builder.setCancelable(false);

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Salvar", null);
        dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button bt = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        salvarDados();
                    }
                });
            }
        });
        dialog.show();

    }

    public void salvarDados(){
        String retorno = controller.salvarLoginSenha(edLoginDia.getText().toString(),
                edSenhaDia.getText().toString(), edNomeDia.getText().toString());
        if(retorno != null){
            if(retorno.contains("Login")){
                edLoginDia.setError(retorno);
                edLoginDia.requestFocus();
            }
            if(retorno.contains("Senha")){
                edSenhaDia.setError(retorno);
                edSenhaDia.requestFocus();
            }
            if(retorno.contains("Nome")){
                edNomeDia.setError(retorno);
                edNomeDia.requestFocus();
            }
        }else{
            Toast.makeText(this,
                    "Usuário salvo com sucesso!",
                    Toast.LENGTH_LONG).show();

            dialog.dismiss();
        }
    }

}