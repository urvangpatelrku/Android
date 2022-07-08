package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Item> {

    private final Context context;
    private final ArrayList<Item> list;

    public MyAdapter(@NonNull Context context, ArrayList<Item> list) {
        super(context, R.layout.listitem, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.listitem,parent,false);

        // 3. Get the two text view from the rowView
        TextView txtName = (TextView) rowView.findViewById(R.id.txtName);
        TextView txtDate = (TextView) rowView.findViewById(R.id.txtDate);
        TextView txtNumber = (TextView) rowView.findViewById(R.id.txtNumber);
        TextView txtTime = (TextView) rowView.findViewById(R.id.txtTime);
        ImageView imgIcon = (ImageView) rowView.findViewById(R.id.imgIcon);

        // 4. Set the text for textView
        txtName.setText(list.get(position).getName());
        txtTime.setText(list.get(position).getTime());
        txtDate.setText(list.get(position).getDate());
        txtNumber.setText(list.get(position).getNumber());
        imgIcon.setBackgroundResource(list.get(position).getImage());

        // 5. retrn rowView
        return rowView;
    }
}
