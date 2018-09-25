package ru.sayakhov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Library.class);
    private static final long serialVersionUID = 2123436181552524206L;

    private Book[] booksList = new Book[0];

    public void getBooksList() {
        LOG.info("Показать все книги в архиве");
        for ( Book i : booksList) {
            System.out.println(i.toString());
        }
    }

    public void setBooksList(Book book) {
        LOG.info("Добавить книгу в архиве: " + book);// создается инфо запис в лог
        final int newSize = booksList.length + 1; // задается размер массива
        Book[] newbooksList = new Book[newSize]; //определяется новый массив с новым увеличенным размером длинны
        System.arraycopy(booksList, 0, newbooksList, 0, booksList.length);//копируется массиввставляется обьект в массив
        newbooksList[newSize-1] = book;//
        booksList = newbooksList;//
    }

    @Override
    public String toString() {
        return "Library{" +
                "booksList=" + Arrays.toString(booksList) +
                '}';
    }
}
