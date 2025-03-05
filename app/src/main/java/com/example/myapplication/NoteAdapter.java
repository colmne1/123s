package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> noteList;
    private Set<Integer> selectedNotes = new HashSet<>();
    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }
    public Set<Integer> getSelectedNotes() {
        return selectedNotes;
    }
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.textViewDate.setText(note.getDate());
        holder.textViewNote.setText(note.getContext());
        holder.checkBoxNote.setOnCheckedChangeListener(null);
        holder.checkBoxNote.setChecked(selectedNotes.contains(position));
        holder.checkBoxNote.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedNotes.add(position);
            } else {
                selectedNotes.remove(position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return noteList.size();
    }
    public void deleteSelectedNotes() {
        List<Note> newList = new ArrayList<>();
        for (int i = 0; i < noteList.size(); i++) {
            if (!selectedNotes.contains(i)) {
                newList.add(noteList.get(i));
            }
        }
        noteList.clear();
        noteList.addAll(newList);
        selectedNotes.clear();
        notifyDataSetChanged();
    }
    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDate;
        TextView textViewNote;
        CheckBox checkBoxNote;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewNote = itemView.findViewById(R.id.textView2);
            checkBoxNote = itemView.findViewById(R.id.checkBox);
        }
    }
}