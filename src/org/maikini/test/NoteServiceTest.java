package org.maikini.test;

import org.maikini.src.model.Note;
import org.maikini.src.service.NoteService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.System.Logger.Level.INFO;

public class NoteServiceTest {
    private final NoteService noteService = new NoteService();
    private final System.Logger logger = System.getLogger(NoteServiceTest.class.getName());

    public void getNoteShouldReturnEmptyListWhenNoNotesAdded() {
        final var actual = noteService.getNotes().stream().toList();
        final var expected = Collections.emptyList();
        assertEquals(actual, expected);
    }

    public void addShouldAddANote() {
        final var note = new Note("Hooray", "Hakim finally gets it!");
        final var actual = noteService.add(note);
        final var expected = note;
        assertEquals(actual, expected);

        final var actualList = noteService.getNotes().stream().toList();
        final var expectedList = List.of(note);
        assertEquals(actualList, expectedList);
    }

    private void assertEquals(Object actual, Object expected) {
        if (!Objects.equals(actual, expected)) {
            logger.log(INFO, "Expected: " + expected + "\n" + "But was: " + actual);
        }
    }
}
