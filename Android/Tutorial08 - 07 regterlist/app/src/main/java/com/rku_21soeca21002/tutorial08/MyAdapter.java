package com.rku_21soeca21002.tutorial08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Users> {
    private final Context context;
    private final ArrayList<Users> list;
    public MyAdapter(@NonNull Context context, ArrayList<Users> list) {
        super(context, R.layout.listview, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.listview,parent,false);

        // 3. Get the two text view from the rowView
        TextView txtName = (TextView) rowView.findViewById(R.id.txtUsername);

        // 4. Set the text for textView
        txtName.setText(list.get(position).getUsername());

        // 5. retrn rowView
        return rowView;
    }
}
