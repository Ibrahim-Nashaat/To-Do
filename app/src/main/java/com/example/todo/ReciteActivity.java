package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ReciteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recite);
        TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        ItemWrapper itemWrapper = (ItemWrapper) getIntent().getSerializableExtra("items");
        String recite = "";
        Map<Item, Integer> itemMap = new HashMap<>();
        for (int i = 0; i < itemWrapper.items.size(); i++) {
            Item item = itemWrapper.items.get(i);
            Integer count = itemMap.get(item);
            if (count == null) {
                itemMap.put(item, 1);
            } else {
                count++;
                itemMap.put(item, count);
            }
        }
        int totalPrice = 0;
        for (Map.Entry<Item, Integer> entry : itemMap.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            recite += item.itemName + "          QTY: " + quantity +
                    "          Price: " + (quantity * item.itemPrice) + '\n';
            totalPrice += item.itemPrice * quantity;
        }
        recite += "Total price: " + totalPrice;
        textView.setText(recite);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReciteActivity.this, "Payment done", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
//                intent.putExtra("editTextValue", "value_here");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}