package com.hg.booksretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hg.booksretrofit.R;
import com.hg.booksretrofit.model.BooksModel;

import java.util.List;

/**
 * Created by Hurman on 17/12/2015.
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<BooksModel> books;
    private int rowLayout;
    public Context mContext;

    public BooksAdapter(List<BooksModel> books, int rowLayout, Context context) {
        this.books = books;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.ViewHolder holder, final int position) {

        holder.name.setText(books.get(position).getName());
        holder.price.setText(books.get(position).getPrice());
        holder.id.setText(books.get(position).getBookId());
        holder.stock.setText(books.get(position).getInStock());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You clicked on item:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price, id, stock;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            price = (TextView) itemView.findViewById(R.id.tv_price);
            id = (TextView) itemView.findViewById(R.id.tv_id);
            stock = (TextView) itemView.findViewById(R.id.tv_stock);

        }
    }
}
