package com.maxima.maximaapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxima.maximaapp.R;
import com.maxima.maximaapp.domain.Produto;
import com.maxima.maximaapp.view.fragment.ListProdFragment;
import com.maxima.maximaapp.view.fragment.MainFragment;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterProdutoRecyclierView extends RecyclerView.Adapter<AdapterProdutoRecyclierView.MyViewHolder>{

    private ListProdFragment fragment;
    private ArrayList<Produto> produtos;

    public AdapterProdutoRecyclierView(ListProdFragment fragment, ArrayList<Produto> produtos) {
        this.fragment = fragment;
        this.produtos = produtos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_produto_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setDados(produtos.get(position));
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView descricao, fornecedor;
        CircleImageView picture;
        public MyViewHolder(View itemView) {
            super(itemView);
            descricao = (TextView) itemView.findViewById(R.id.item_pro_desc_txt);
            fornecedor= (TextView) itemView.findViewById(R.id.item_pro_fornecedor_txt);
            picture = (CircleImageView) itemView.findViewById(R.id.item_picture_pro);
        }

        public void setDados(Produto produto) {
            descricao.setText(produto.getCodigo() + " - " + produto.getDescricao());
            fornecedor.setText(produto.getFornecedor().getName());
            picture.setImageResource(produto.getFornecedor().getPicture());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
