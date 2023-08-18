package org.maikini.src.service;

import org.maikini.src.model.Note;

import java.util.ArrayList;
import java.util.List;
/**
 * This class handles CRUD operations for notes.
 */
public class NoteService {
    // need a way to store multiple notes [ list ]
    private final List<Note> notes = new ArrayList<>();

    // need a way to add a new note to the list [ method ]
    public void addNote(String title, String body) {
        //        😓 append? how do I add a note to the notes List<>? It should take a note and add it. TODO
    }
}
