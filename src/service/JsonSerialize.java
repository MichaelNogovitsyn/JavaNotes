package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import note.Notes;

import java.io.*;
import java.util.Arrays;

public class JsonSerialize {
    ObjectMapper mapper = new ObjectMapper();


    public boolean save(File file, Notes notes) {
        try {
            // Запишим
            FileWriter writer = new FileWriter(file, false);
                writer.write(notes.toString());
                writer.flush();

//            FileReader reader = new FileReader(file);
//
//            char[] buf = new char[256];
//            int c;
//            while ((c = reader.read(buf)) > 0) {
//                if (c < 256) {
//                    buf = Arrays.copyOf(buf, c);
//                }
//            }
//            System.out.println("File contain:");
//            System.out.print(buf);

            //это объект Jackson, который выполняет сериализацию
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            // сама сериализация: 1-куда, 2-что
            mapper.writeValue(file, notes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object load(File file) {
        try {
            FileReader reader = new FileReader(file);
            Object object= mapper.readValue(reader, Notes.class);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

