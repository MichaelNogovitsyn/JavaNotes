package comparator;

import note.Note;

import java.util.Comparator;

public class ComparatorByData implements Comparator<Note> {

    @Override
    public int compare(Note o1, Note o2) {
        if (o2.getData() == o1.getData()) {
            return 0;
        } else if (o1.getData().before(o2.getData())) {
            return -1;
        } else {
            return 0;
        }
    }
}
