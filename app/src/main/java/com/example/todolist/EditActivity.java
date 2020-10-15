package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    ImageButton btCancelEdit;
    ImageButton btSaveDetail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_edit);
        setBtCancelEditListener();
        setBtSaveDetailListener();
    }

    private void setBtCancelEditListener(){
        btCancelEdit = (ImageButton) findViewById(R.id.btCancelEdit);
        btCancelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setBtSaveDetailListener(){
        btSaveDetail = (ImageButton) findViewById(R.id.btSaveDetail);
        btSaveDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
