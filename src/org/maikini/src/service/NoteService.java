package org.maikini.src.service;

import org.maikini.src.model.Note;

import java.util.ArrayList;
import java.util.Collection;
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
     * @param note that gets added
     * @return the added Note
     */
    public Note add(Note note) {
        notes.add(note);
        return note;
    }

    /**
     * This method returns all notes
     * @return the collections of notes
     */
    public Collection<Note> getNotes() {
        return notes;
    }
}
