package org.maikini;

import java.util.ArrayList;
import java.util.List;

public class NoteTakingApp {
    //nested class to represent a single note
    static class Note {
        private String title; // variable to store title
        private String body; // variable to store title

        // need a way to build/manufacture a note [constructor]

        public Note(String title, String body) {
            this.title = title;
            this.body = body;
        }
    }
    // need a way to store multiple notes [ list ]
    private List<Note> notes = new ArrayList<>();

    // need a way to add a new note to the list [ method ]
    public void addNote(String title, String body) {
//        😓 append? how do I add a note to the notes List<>? It should take a note and add it. TODO
    }
}
