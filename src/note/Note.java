package note;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
@JsonAutoDetect
public class Note {

    private int id;
    private String header;
    private String body;

    private Date data;
    @JsonIgnore
    Calendar calendar = new GregorianCalendar(Locale.getDefault());
    @JsonIgnore
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Note()
    {
        this.header = null;
        setData();
    }
    Note(String header)
    {
        this.header = header;
        setData();
    }

    public Note(String header, String body){
        this(header);
        this.body = body;
}
      public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getData() {
        return data;
    }

    public void setData() {
        this.data = calendar.getTime();
    }
    @JsonIgnore
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        sb.append("; ");
        sb.append(formatter.format(data));
        /*sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        sb.append(".");
        sb.append(calendar.get(Calendar.MONTH));
        sb.append(".");
        sb.append(calendar.get(Calendar.YEAR));
        sb.append("; ");
        sb.append(calendar.get(Calendar.HOUR));
        sb.append(":");
        sb.append(calendar.get(Calendar.MINUTE));*/
        sb.append("; ");
        sb.append(header);
        sb.append("; ");
        sb.append(body);
        return sb.toString();
    }
}
