package com.rku_21soeca21002.demovolley;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    ArrayList<Users> users;
    Context context;
    public UserAdapter(ArrayList<Users> users,Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.txtName.setText(users.get(position).getName());
        holder.txtEmail.setText(users.get(position).getEmail());
        holder.txtNumber.setText(users.get(position).getNumber());
        holder.txtWebsite.setText(users.get(position).getWebsite());
        holder.btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UserDetail.class);
                intent.putExtra("userid",users.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtEmail,txtWebsite,txtNumber;
        Button btnNavigate;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtWebsite = itemView.findViewById(R.id.txtWebsite);
            btnNavigate = itemView.findViewById(R.id.btnNavigate);
        }
    }

}
