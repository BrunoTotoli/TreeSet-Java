package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Log implements Comparable<Log> {
    private String name;
    private Date instant;
    private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss'Z'");

    public Log(String name, Date instant) {
        this.name = name;
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Date: " + sdf.format(instant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(name, log.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInstant() {
        return instant;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    @Override
    public int compareTo(Log o) {
        return o.getName().toUpperCase().compareTo(this.getName().toUpperCase());
    }
}
