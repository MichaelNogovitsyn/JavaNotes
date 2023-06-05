package note;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import comparator.ComparatorByData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonAutoDetect
public class Notes {
    public List<Note> notes = new ArrayList<>();
    @JsonIgnore
    private IdGenerator idGenerator = new IdGenerator();

    public Notes() {
    }

    public Notes(List<Note> notes) {
        this();
        this.notes = notes;
    }
    @JsonIgnore
    public boolean addNote(Note newNote) {
        if ((newNote == null) || (newNote.getId() > idGenerator.idLast())) {
            return false;
        }
        newNote.setId(idGenerator.getId());
        this.notes.add(newNote);
        return true;
    }
    @JsonIgnore
    public Note findNote(String noteHeader) {
        for (Note note:this.notes ) {
            if (note.getHeader().equals(noteHeader))
            {return note;}
        }
        return null;
    }
    @JsonIgnore
    public void sortByName() {
        notes.sort(new ComparatorByData());
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
