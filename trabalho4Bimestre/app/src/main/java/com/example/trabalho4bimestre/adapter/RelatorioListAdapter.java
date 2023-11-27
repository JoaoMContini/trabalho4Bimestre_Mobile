package com.example.trabalho4bimestre.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho4bimestre.R;
import com.example.trabalho4bimestre.model.Venda;

import java.util.ArrayList;

public class RelatorioListAdapter extends RecyclerView.Adapter<RelatorioListAdapter.ViewHolder> {

    private ArrayList<Venda> listaRelatorio;
    private Context context;

    public RelatorioListAdapter(ArrayList<Venda> listaRelatorio, Context context) {
        this.listaRelatorio = listaRelatorio;
        this.context = context;
    }



    @NonNull
    @Override
    public RelatorioListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listitem = inflater.inflate(R.layout.item_list_relatorio, parent, false);

        return new RelatorioListAdapter.ViewHolder(listitem);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatorioListAdapter.ViewHolder holder, int position) {
        Venda vendaSelecionada = listaRelatorio.get(position);
        holder.tvCodigo.setText(String.valueOf(vendaSelecionada.getIdVenda()));
        holder.tvProduto.setText(String.valueOf(vendaSelecionada.getProduto()));
        holder.tvQuantidade.setText(String.valueOf(vendaSelecionada.getQuantidade()));
        holder.tvVendedor.setText(vendaSelecionada.getVendedor());
        holder.tvTipoPagamento.setText(vendaSelecionada.getPagamento());
        holder.tvValorUnitario.setText(String.valueOf("R$ " + vendaSelecionada.getValorUnitario()));
        holder.tvValorTotal.setText(String.valueOf("R$ " + vendaSelecionada.getValorTotal()));
    }

    @Override
    public int getItemCount() {
        return this.listaRelatorio.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvCodigo;
        public TextView tvProduto;
        public TextView tvQuantidade;
        public TextView tvVendedor;
        public TextView tvTipoPagamento;
        public TextView tvValorUnitario;
        public TextView tvValorTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvCodigo = itemView.findViewById(R.id.tvCodigo);
            this.tvProduto = itemView.findViewById(R.id.tvProduto);
            this.tvQuantidade = itemView.findViewById(R.id.tvQuantidade);
            this.tvVendedor = itemView.findViewById(R.id.tvVendedor);
            this.tvTipoPagamento = itemView.findViewById(R.id.tvTipoPagamento);
            this.tvValorUnitario = itemView.findViewById(R.id.tvValorUnitario);
            this.tvValorTotal = itemView.findViewById(R.id.tvValorTotal);
        }
    }
}
