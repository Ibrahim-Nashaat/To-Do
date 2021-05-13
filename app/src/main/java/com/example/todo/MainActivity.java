package com.example.todo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Spinner spinner;
    List<Item> cartItems;
    List <Item> shoppingItems;
    MyListAdapter adapter;
    MyAdapter myAdapter;
    ImageButton imageButton;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= findViewById(R.id.recycler_view);
            spinner = (Spinner) findViewById(R.id.spinner);
            imageButton = (ImageButton) findViewById(R.id.imageButton);
            floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);


            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
Intent intent = new Intent(MainActivity.this, ReciteActivity.class);
ItemWrapper itemWrapper = new ItemWrapper();
itemWrapper.items = cartItems;
intent.putExtra("items", itemWrapper);
startActivityForResult(intent,1);
                        }
                    });
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item item = (Item) spinner.getSelectedItem();
                    cartItems.add(item);
                    adapter.notifyDataSetChanged();
                }
            });
        cartItems = new ArrayList<>();
        shoppingItems = new ArrayList<>();
        myAdapter = new MyAdapter(MainActivity.this, R.layout.spinner_item, shoppingItems);
        setShoppingItems();
        spinner.setAdapter(myAdapter);

      adapter = new MyListAdapter(cartItems);
      rv.setHasFixedSize(true);
      rv.setLayoutManager(new LinearLayoutManager(this));
      rv.setAdapter(adapter);

    }
    private void setShoppingItems() {
        Item item = new Item();
        item.itemName = "Orange";
        item.itemPrice = 10;
        Item item1 = new Item();
        item1.itemName = "Apple";
        item1.itemPrice = 15;
        Item item2 = new Item();
        item2.itemName = "Meat";
        item2.itemPrice = 100;
        shoppingItems.add(item);
        shoppingItems.add(item1);
        shoppingItems.add(item2);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        cartItems.clear();
        adapter.notifyDataSetChanged();

    }

}