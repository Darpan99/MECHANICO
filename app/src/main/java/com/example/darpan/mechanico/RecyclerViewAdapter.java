package com.example.darpan.mechanico;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.darpan.mechanico.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<bookrealtime> mData;


    public RecyclerViewAdapter(Context mcontext, ArrayList<bookrealtime> mData) {
        this.mcontext = mcontext;
        this.mData = mData;

    }
    public static class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tv_car;
        TextView tv_carmodel;

        TextView tv_carfuel;
        TextView tv_address;
        TextView tv_time;
        TextView tv_date;
        TextView tv_otp;






        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_car=itemView.findViewById(R.id.ucar);
            tv_carmodel=itemView.findViewById(R.id.umodel);
            tv_carfuel=itemView.findViewById(R.id.ufuel);
            tv_address=itemView.findViewById(R.id.uaddress);
            tv_time=itemView.findViewById(R.id.utime);
            tv_date=itemView.findViewById(R.id.udate);
            tv_otp=itemView.findViewById(R.id.uotp);


        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view=inflater.inflate(R.layout.rtdu_row_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.tv_car.setText(String.valueOf(mData.get(i).getCar()));
        myViewHolder.tv_carmodel.setText(String.valueOf(mData.get(i).getCar_model()));
        myViewHolder.tv_carfuel.setText(String.valueOf(mData.get(i).getFuel_type()));
        myViewHolder.tv_address.setText(String.valueOf(mData.get(i).getAddress()));
        myViewHolder.tv_date.setText(String.valueOf(mData.get(i).getDate()));

        myViewHolder.tv_time.setText(String.valueOf(mData.get(i).getTime()));
        myViewHolder.tv_otp.setText(String.valueOf(mData.get(i).getOtp()));





    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



}
