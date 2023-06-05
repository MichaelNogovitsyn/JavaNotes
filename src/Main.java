import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import note.Note;
import note.Notes;
import service.JsonSerialize;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        JsonSerialize jsonSerialize = new JsonSerialize();
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
        if (listnotes.findNote("1") != null) {
            System.out.println(listnotes.findNote("1").getInfo());
        } else System.out.println("Такой записи нет");

        //сохраним
        StringWriter writer = new StringWriter();
        if (jsonSerialize.save(writer, listnotes))
        {
            System.out.println(writer.toString());
        } else  System.out.println("Запись не удалась");

        // Загрузим
        Notes newNotes = new Notes();
        newNotes = (Notes) jsonSerialize.load(writer);
        System.out.println(newNotes.toString());





        //System.out.println(notes.toString());


    }
}