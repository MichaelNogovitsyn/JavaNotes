import note.Note;
import note.Notes;
import service.Service;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File data = new File("data.txt");
        Notes listnotes = new Notes();
        List<Note> selectedNotes = new ArrayList<>();
        System.out.println("Hello my friend!");
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        String header;
        String newheader;
        String body;
        String key = "";
        int year;
        String str;

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
                    if ((listnotes = service.load(listnotes, data)) != null) {
                        listnotes.setLastId();
                        System.out.println("Загрузка выполнена успешно : \n");

                    } else System.out.println("Загрузка не удалась");
                    break;
                case "2":
                    print("Введите заголовок заметки");
                    header = scanner.next();
                    print("Введите текст заметки");
                    body = scanner.next();
                    Note newNote = new Note(header, body);
                    listnotes.addNote(newNote);
                    break;

                case "3":
                    listnotes.sortByData();
                    print(listnotes.toString());
                    break;
                case "4":
                    print("Введите искомый заголовок записки: ");
                    header = scanner.next();
                    if (listnotes.findNote(header) != null) {
                        print(listnotes.findNote(header).getInfo());
                    } else System.out.println("Такой записи нет");
                    break;
                case "5":
                    print("Введите заголовок заметки которую вы хотите изменить:");
                    header = scanner.next();
                    if (listnotes.findNote(header) != null) {
                        print("Ваша записка:");
                        print(listnotes.findNote(header).getInfo());
                    } else {
                        System.out.println("Такой записи нет");
                        break;
                    }
                    print("Введите новый заголовок:");
                    newheader = scanner.next();
                    print("Введите новый текст:");
                    body = scanner.next();
                    print("Введите новый год:");
                    str = scanner.next();
                    try {
                        year = Integer.parseInt(str);
                        System.out.println(year);
                        selectedNotes=service.selection(listnotes,year);

                        for (Note note:selectedNotes)
                        {
                            print(note.getInfo());
                        }
                        listnotes.findNote(header).setHeader(newheader);
                        listnotes.findNote(newheader).setBody(body);
                        listnotes.findNote(newheader).setYear(year);
                    }

                    catch (NumberFormatException nfe)
                    {
                        print("Год введен не корректно ");
                        print("Записка не сохранена");
                        break;
                    }

                    print("Записка изменена успешно");
                    break;
                case "6":
                    print("Введите искомый год записей: ");
                    str = scanner.next();
                    try {
                        year = Integer.parseInt(str);
                        selectedNotes=service.selection(listnotes,year);
                        if (selectedNotes.isEmpty()){
                            print("Таких записей нет");
                            break;}
                        for (Note note:selectedNotes)
                        {
                            print(note.getInfo());
                        }
                    }
                    catch (NumberFormatException nfe)
                    {
                        print("Год введен не корректно ");
                    }

                    break;
                case "7":
                    //сохраним в файл
                    if (service.save(listnotes, data)) {
                        print("Сохранено");
                    } else print("Сохранение не удалось");
                    break;
                case "8":
                    print("Введите искомый заголовок записки: ");
                    header = scanner.next();
                    if (listnotes.findNote(header) != null) {
                        print("Запись удалена:");
                        print(listnotes.findNote(header).getInfo());
                        listnotes.notes.remove(listnotes.findNote(header));
                    } else System.out.println("Такой записи нет");
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
    }

    public static void print(String text) {
        System.out.println(text);
    }
}