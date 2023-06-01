import note.Note;
import note.Notes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Note note1 = new Note("1", "asdas");
        Note note2 = new Note("2", "text");
        Note note3 = new Note("3", "text Some");

        Notes listnotes = new Notes();
        listnotes.addNote(note1);
        listnotes.addNote(note2);
        listnotes.addNote(note3);
        System.out.println(listnotes.toString());

        System.out.println("поиск:");
        if (listnotes.findNote("1") !=null)
        {
            System.out.println(listnotes.findNote("1").getInfo());
        }
        else System.out.println("Такой записи нет");

    }
}