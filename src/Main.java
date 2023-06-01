import note.Note;
import note.Notes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Note note1 = new Note("2", "asdas");
        Notes listnotes = new Notes();
        listnotes.addNote(note1);
        System.out.println(listnotes.toString());

    }
}