 package com.example.todo;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.text.BreakIterator;
import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private List<Item> listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(List<Item> listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.viewholder_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       final Item item = listdata.get(position);
       holder.itemNameTv.setText(item.itemName);
       holder.itemPriceTv.setText(Float.toString(item.itemPrice));
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemNameTv;
        public TextView itemPriceTv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemNameTv = (TextView) itemView.findViewById(R.id.textView2);
            this.itemPriceTv = (TextView) itemView.findViewById(R.id.textView4);
        }
    }
}
