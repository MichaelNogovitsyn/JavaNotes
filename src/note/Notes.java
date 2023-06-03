package note;

import note.Note;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notes implements Serializable {
    private List<Note> notes = new ArrayList<>();
    private IdGenerator idGenerator = new IdGenerator();

    public Notes() {
    }

    public Notes(List<Note> notes) {
        this();
        this.notes = notes;
    }

    public boolean addNote(Note newNote) {
        if ((newNote == null) || (newNote.getId() > idGenerator.idLast())) {
            return false;
        }
        newNote.setId(idGenerator.getId());
        this.notes.add(newNote);
        return true;
    }
    public Note findNote(String noteHeader) {
        for (Note note:this.notes ) {
            if (note.getHeader().equals(noteHeader))
            {return note;}
        }
        return null;
    }

    @Override
    public String toString() {
        if (!(notes.isEmpty())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ваши записи:");
            sb.append("\n");
            for (Note note : notes) {
                sb.append(note.getInfo());
                sb.append("\n");
            }
            return sb.toString();
        } else return " Записей нет";
    }
}
