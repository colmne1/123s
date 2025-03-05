package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<Note> noteList;
    private NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteList = new ArrayList<>();
        RecyclerView recyclerViewNotes = findViewById(R.id.recycle);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(noteList);
        recyclerViewNotes.setAdapter(noteAdapter);
        Button buttonAddNote = findViewById(R.id.sozd);
        buttonAddNote.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
            startActivityForResult(intent,1);
        });
        Button buttonDelete=findViewById(R.id.delete);
        buttonDelete.setOnClickListener(v -> {
            noteAdapter.deleteSelectedNotes();
        });
    }
    @Override
    protected void OnActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1 & resultCode==-1){
            String noteContent = data.getStringExtra("note");
            String currentDate = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
            noteList.add(new Note(currentDate,noteContent));
            noteAdapter.notifyDataSetChanged();
        }
    }

}
