package com.rku_21soeca21002.exampractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VolleyAdapter extends RecyclerView.Adapter<VolleyAdapter.VolleyViewHolder> {
    ArrayList<VolleyPOJO> pojos;

    public VolleyAdapter(ArrayList<VolleyPOJO> pojo) {
        this.pojos = pojo;
    }

    @NonNull
    @Override
    public VolleyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.volleylist,parent,false);
        return new VolleyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolleyViewHolder holder, int position) {
        holder.txtUsername.setText(pojos.get(position).getName());
        holder.txtPhone.setText(pojos.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return pojos.size();
    }

    class VolleyViewHolder extends RecyclerView.ViewHolder{
        TextView txtUsername,txtPhone;
        public VolleyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUsername = itemView.findViewById(R.id.txtUsername);
            txtPhone = itemView.findViewById(R.id.txtPhone);
        }
    }
}
