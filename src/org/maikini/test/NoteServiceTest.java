package org.maikini.test;

import org.maikini.src.service.NoteService;

import java.util.Collections;
import java.util.Objects;

import static java.lang.System.Logger.Level.INFO;

public class NoteServiceTest {
    private final NoteService noteService = new NoteService();

    public void getNoteShouldReturnEmptyListWhenNoNotesAdded() {
        final var logger = System.getLogger("NoteLogger");
        final var actual = noteService.getNotes();
        final var expected = Collections.emptyList();
        if (!Objects.equals(actual, expected)) {
            logger.log(INFO, "Expected: " + expected + "\n" + "But was: " + actual);
        }
    }

    public void addShouldAddANote() {}
}
