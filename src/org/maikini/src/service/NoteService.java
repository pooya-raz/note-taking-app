package org.maikini.src.service;

import org.maikini.src.model.Note;

import java.util.ArrayList;
import java.util.List;
/**
 * This class handles CRUD operations for notes.
 */
public class NoteService {
    /**
     * This is the data structure that holds all the notes.
     **/
    private final List<Note> notes = new ArrayList<>();

    /**
     * This method adds a new note.
     * @param title The title of the note.
     * @param body The body of the note.
     */
    public void addNote(String title, String body) {
        //        😓 append? how do I add a note to the notes List<>? It should take a note and add it. TODO
    }

    /**
     * This method adds a new note.
     */
    public void add(Note note) {
        //
    }

    /**
     * This method returns all notes
     */
    public List<Note> getNotes() {
        return notes;
    }
}
