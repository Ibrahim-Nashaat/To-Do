package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

// Creating an Adapter Class
public class MyAdapter extends ArrayAdapter {
    List<Item> objects;
    public MyAdapter(Context context, int textViewResourceId, List<Item>objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.spinner_item, parent, false);
        Item item = objects.get(position);
        TextView tvItemName = (TextView) layout.findViewById(R.id.textView5);
        TextView ItemPrice = (TextView) layout.findViewById(R.id.textView6);
        tvItemName.setText(item.itemName);
        ItemPrice.setText(Float.toString(item.itemPrice));


        return layout;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
