package service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import note.Notes;

import java.io.*;

public class JsonSerialize {
    ObjectMapper mapper = new ObjectMapper();
    StringWriter writer;

    public boolean save(StringWriter writer, Notes notes) {
        try {
            //писать результат сериализации будем во Writer(StringWriter)
            this.writer = writer;
            //это объект Jackson, который выполняет сериализацию
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            // сама сериализация: 1-куда, 2-что
            mapper.writeValue(writer, notes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object load(StringWriter stringWriter) {
        try {
            //преобразовываем все записанное во StringWriter в строку
            StringReader reader = new StringReader(stringWriter.toString());
            Object object= mapper.readValue(reader, Notes.class);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

