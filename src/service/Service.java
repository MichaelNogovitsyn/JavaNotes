package service;

import note.Note;
import note.Notes;

import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Service {
    JsonSerialize jsonSerialize = new JsonSerialize();


    public Notes load(Notes notes, File file) {
        // Загрузим
        notes = (Notes) jsonSerialize.load(file);
        if (notes != null) {
            return notes;
        } else return null;
    }

    public boolean save(Notes notes, File file) {
        // Загрузим
        if (jsonSerialize.save(file, notes)) {
            return true;
        } else return false;
    }

    public List<Note> selection(Notes notes, int year) {
        List<Note> selectedNotes = new ArrayList<>();
        for (int i = 0; i < notes.notes.size(); i++) {
            if (notes.notes.get(i).getYear() == year) {
                selectedNotes.add(notes.notes.get(i));
            }
        }
        if (selectedNotes==null) return null;
        return selectedNotes;
    }

}
