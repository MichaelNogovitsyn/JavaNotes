package note;
import java.io.Serializable;

public class IdGenerator implements Serializable {
    int id;

    public IdGenerator() {
        this.id = 1;
    }

    public int getId() {
        return this.id++;
    }

    public int idLast() {
        return this.id;
    }
}
