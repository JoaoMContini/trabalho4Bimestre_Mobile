package com.example.trabalho4bimestre.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trabalho4bimestre.R;
import com.example.trabalho4bimestre.adapter.PagamentoListAdapter;
import com.example.trabalho4bimestre.adapter.RelatorioListAdapter;
import com.example.trabalho4bimestre.controller.VendaController;
import com.example.trabalho4bimestre.model.Pagamento;
import com.example.trabalho4bimestre.model.Venda;

import java.util.ArrayList;

public class RelatorioActivity extends AppCompatActivity {

    private VendaController controller;
    private RecyclerView rvRelatorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);
        controller = new VendaController(this);
        rvRelatorio = findViewById(R.id.rvRelatorio);

        atualizarLista();
    }

    private void atualizarLista(){
        ArrayList<Venda> listaRelatorio = controller.retornarTodasVendas();
        RelatorioListAdapter adapter = new RelatorioListAdapter(listaRelatorio, this);
        rvRelatorio.setLayoutManager(new LinearLayoutManager(this));
        rvRelatorio.setAdapter(adapter);
    }
}

