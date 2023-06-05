import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import note.Note;
import note.Notes;
import service.JsonSerialize;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        JsonSerialize jsonSerialize = new JsonSerialize();
        File data = new File("data.txt");
        System.out.println("Hello world!");
        Note note1 = new Note("1", "asdas");
        Note note2 = new Note("2", "text");
        Note note3 = new Note("3", "text Some");

        Notes listnotes = new Notes();
        listnotes.addNote(note1);
        listnotes.addNote(note2);
        listnotes.addNote(note3);
        //System.out.println(listnotes.toString());

        System.out.println("поиск:");
        if (listnotes.findNote("1") != null) {
            System.out.println(listnotes.findNote("1").getInfo());
        } else System.out.println("Такой записи нет");

        //сохраним в файл
//        if (jsonSerialize.save(data, listnotes)) {
//        } else System.out.println("Запись не удалась");

        // Загрузим
        listnotes = (Notes) jsonSerialize.load(data);
        if (listnotes != null) {
            System.out.println("Загрузка выполнена успешно : \n" + listnotes.toString());
        } else System.out.println("Загрузка не удалась");

        // выборка по дате
        System.out.println(note1.getData());
    }


}