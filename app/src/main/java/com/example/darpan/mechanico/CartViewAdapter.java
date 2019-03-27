package com.example.darpan.mechanico;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darpan.mechanico.R;

import java.util.ArrayList;
import java.util.List;

public class CartViewAdapter extends RecyclerView.Adapter<CartViewAdapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<services_realtime> mData;

    public CartViewAdapter(Context mcontext, ArrayList<services_realtime> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.sr_row_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_cng.setText(String.valueOf(mData.get(i).getCNG()));
        myViewHolder.tv_denting.setText(String.valueOf(mData.get(i).getDenting()));
        myViewHolder.tv_services.setText(String.valueOf(mData.get(i).getService()));
        myViewHolder.tv_tyre.setText(String.valueOf(mData.get(i).getTyre()));


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tv_cng;
        TextView tv_denting;
        TextView tv_services;
        TextView tv_tyre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_cng=itemView.findViewById(R.id.ucng);
            tv_denting=itemView.findViewById(R.id.udenting);
            tv_services=itemView.findViewById(R.id.uservices);

            tv_tyre=itemView.findViewById(R.id.utyre);

        }
    }



}
