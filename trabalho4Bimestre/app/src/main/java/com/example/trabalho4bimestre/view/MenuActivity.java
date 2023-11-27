package com.example.trabalho4bimestre.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalho4bimestre.R;
import com.example.trabalho4bimestre.model.Produto;
import com.example.trabalho4bimestre.model.Relatorio;
import com.example.trabalho4bimestre.model.Venda;

public class MenuActivity extends AppCompatActivity {

    private Button btVenda;
    private Button btProduto;
    private Button btPagamento;
    private Button btRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btVenda = findViewById(R.id.btVenda);
        btProduto = findViewById(R.id.btProduto);
        btPagamento = findViewById(R.id.btPagamento);
        btRelatorio = findViewById(R.id.btRelatorio);

        btVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVenda();
            }
        });

        btProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirProduto();
            }
        });

        btPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPagamento();
            }
        });

        btRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRelatorio();
            }
        });
    }


    public void abrirVenda(){
     Intent intent = new Intent(this, VendaActivity.class);
     startActivity(intent);
    }
    public void abrirProduto(){
     Intent intent = new Intent(this, ProdutoActivity.class);
     startActivity(intent);
    }
    public void abrirPagamento(){
     Intent intent = new Intent(this, PagamentoActivity.class);
     startActivity(intent);
    }
    public void abrirRelatorio(){
     Intent intent = new Intent(this, RelatorioActivity.class);
     startActivity(intent);
    }

}