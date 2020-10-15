package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ImageButton btEditDetail;
    ImageButton btDelete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_detail);
        setBtDeleteListener();
        setBtEditDetailListener();
    }

    private void setBtEditDetailListener(){
        btEditDetail = (ImageButton) findViewById(R.id.btEditDetail);
        btEditDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setBtDeleteListener(){
        btEditDetail = (ImageButton) findViewById(R.id.btEditDetail);
        btEditDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
