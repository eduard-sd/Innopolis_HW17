package ru.sayakhov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Book implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(Book.class);
    private static final long serialVersionUID = -3897419761170705428L;


    private String name;
    private String author;
    private SimpleDateFormat date;

    public Book(String name, String author, SimpleDateFormat date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date.toPattern() +
                '}';
    }
}
