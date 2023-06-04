import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import note.Note;
import note.Notes;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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

        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // сама сериализация: 1-куда, 2-что
       // mapper.writeValue(writer, note1);
        mapper.writeValue(writer, listnotes);

        //преобразовываем все записанное во StringWriter в строку
        String result = writer.toString();
        System.out.println("writer:"+ result);

        StringReader reader = new StringReader(writer.toString());
        //Note note5 = mapper.readValue(reader, Note.class);
        Notes notes = mapper.readValue(reader, Notes.class);
        System.out.println(notes.toString());


    }
}