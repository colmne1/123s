package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.add_note);
        EditText editTextNote = findViewById(R.id.editTextText);
        Button buttonSave = findViewById(R.id.button);
        buttonSave.setOnClickListener(v -> {
            String noteContent = editTextNote.getText().toString();
            if(!noteContent.isEmpty()){
                Intent intent = new Intent();
                intent.putExtra("note", noteContent);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}
