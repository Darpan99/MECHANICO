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

public class myprofile_adapter extends RecyclerView.Adapter<myprofile_adapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<Realtime_database_users> mData;

    public myprofile_adapter(Context mcontext, ArrayList<Realtime_database_users> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.mp_row_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_usernamme.setText(String.valueOf(mData.get(i).getUser_name()));
        myViewHolder.tv_useremail.setText(String.valueOf(mData.get(i).getUser_email()));
        myViewHolder.tv_usernumber.setText(String.valueOf(mData.get(i).getUser_number()));



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tv_usernamme;
        TextView tv_useremail;
        TextView tv_usernumber;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_usernamme=itemView.findViewById(R.id.uname);
            tv_useremail=itemView.findViewById(R.id.uemail);
            tv_usernumber=itemView.findViewById(R.id.unumber);



        }
    }



}
