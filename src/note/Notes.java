package note;

import note.Note;

import java.util.ArrayList;
import java.util.List;

public class Notes {
    private List<Note> notes = new ArrayList<>();
    private IdGenerator idGenerator = new IdGenerator();
    public Notes(){
    }
    public Notes(List<Note> notes) {
        this();
        this.notes = notes;
    }

    public boolean addNote(Note newNote) {
        if ((newNote == null) || (newNote.getId() > idGenerator.getId())) {
            return false;
        }
        this.notes.add(newNote);
        newNote.setId(idGenerator.getId());
        return true;
    }

    @Override
    public String toString() {
        if (!(notes.isEmpty())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ваши записи:");
            sb.append("\n");
            for ( Note note : notes) {
                sb.append(note.getInfo());
                sb.append("\n");
            }
            return sb.toString();
        } else return " Записей нет";
    }
}
