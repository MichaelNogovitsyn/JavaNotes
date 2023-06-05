import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import note.Note;
import note.Notes;
import service.JsonSerialize;
import service.Service;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File data = new File("data.txt");
        Notes listnotes = new Notes();
        JsonSerialize jsonSerialize = new JsonSerialize();
        System.out.println("Hello my friend!");
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        String header;
        String body;
        String key = "";

       // listnotes = (Notes) jsonSerialize.load(data);

        while (key != "9") {
            print(" Введите:\n " +
                    "1 - Загрузить заметки из файла\n " +
                    "2 - Добавить заметку\n " +
                    "3 - Посмотреть список заметок\n " +
                    "4 - Найти заметку по имени \n " +
                    "5 - Редактировать заметку \n " +
                    "6 - Сделать выборку по дате \n " +
                    "7 - Сохранить заметки \n " +
                    "8 - Удалить заметку \n " +
                    "9 - Выйти");

            key = scanner.next();
            switch (key) {

                case "1":
                    if  ((listnotes= service.load(listnotes, data))!= null) {
                        listnotes.setLastId();
                        System.out.println("Загрузка выполнена успешно : \n");

                    } else System.out.println("Загрузка не удалась");
                    break;
                case "2":
                    System.out.println("Введите заголовок заметки");
                    header= scanner.next();
                    System.out.println("Введите текст заметки");
                    body= scanner.next();
                    Note newNote = new Note(header,body);
                    listnotes.addNote(newNote);
                    break;

                case "3":
                    print(listnotes.toString());
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    print("Работа завершена");
                    key = "6";
                    break;
                case "7":
                    print("Работа завершена");
                    key = "6";
                    break;
                case "8":
                    print("Работа завершена");
                    key = "6";
                    break;
                case "9":
                    print("Работа завершена");
                    key = "9";
                    break;
                default:
                    print("Такой команды нет");
                    break;
            }
        }

        Note note1 = new Note("1", "asdas");
        Note note2 = new Note("2", "text");
        Note note3 = new Note("3", "text Some");


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


        // выборка по дате
        listnotes.sortByName();
        System.out.println("Сортировка : \n" + listnotes.toString());

    }

    public static void print(String text) {
        System.out.println(text);
    }
}