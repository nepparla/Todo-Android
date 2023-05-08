package com.dev.todo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String TAG = "Todo-App";
    Button addButton;
    EditText addItemsET;
    ArrayAdapter listAA;
    ListView listView;
    ArrayList addItemsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemsET = findViewById(R.id.editText);
        addButton = findViewById(R.id.button);
        addItemsArrayList = new ArrayList();
        listView = findViewById(R.id.listView);
        listAA = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, addItemsArrayList);
        listView.setAdapter(listAA);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addButton.setOnClickListener(this::onCLick);
    }

    void onCLick(View view) {
        switch (view.getId()) {
            case R.id.button:
//                addItemsArrayList.add("Hello");
//                addItemsArrayList.add("Hello");
//                addItemsArrayList.add("Hello");
                Log.d(TAG, "onCLick: length" + addItemsET.getText().toString().trim().length());
                if (addItemsET.getText().toString().trim().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Something", Toast.LENGTH_SHORT).show();
                } else {
                    listAA.add(addItemsET.getText().toString());
                    addItemsET.setText("");
                }
//                listAA.remove();
        }
    }
}