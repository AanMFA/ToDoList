package com.example.todolist.data.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SharedTaskDatabase {
    private static final String PATH = "shared";
    public static final DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference(PATH);

    private SharedTaskDatabase() {
    }
}
