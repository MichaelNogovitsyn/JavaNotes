package service;

import note.IdGenerator;
import note.Notes;

import java.io.File;

public class Service {
    JsonSerialize jsonSerialize = new JsonSerialize();

    public Notes load(Notes notes, File file) {
        // Загрузим
        notes = (Notes) jsonSerialize.load(file);
        if (notes != null) {
            return notes;
        } else return null;
    }
}
