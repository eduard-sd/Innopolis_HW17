package ru.sayakhov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class.getName());
/*
*Есть набор объектов типа "Книга". Каждая книга имеет название, автора, год издания. Можно больше, по желанию.

Программа должна уметь:

добавлять книгу в библиотеку.
показывать список книг в библиотеке.
восстанавливать содержимое библиотеки после перезапуска.
показывать соответствующее сообщение в случае ошибок.
Важно!

потоки обязательно должны закрываться
отсутствие файла на диске - не ошибка, а частный случай пустой библиотеки
* */
    public static void main(String[] args) {


        Book book1 = new Book("Листья травы 12 рец.", "Уитмен Уолт", new SimpleDateFormat("2018-09-25"));
        Book book2 = new Book("Пиковая дама", "Пушкин Александр Сергеевич", new SimpleDateFormat("2000-10-11"));
        Book book3 = new Book("Смерть Артура", "Мэлори Томас", new SimpleDateFormat("1900-01-01"));
        Book book4 = new Book("Только для левшей", "Ютци Себастиан", new SimpleDateFormat("1950-05-22"));


        Library lib1 = new Library();
        lib1.addBooks(book1);
        lib1.addBooks(book2);
        lib1.addBooks(book3);
        lib1.addBooks(book4);

        lib1.printBooksList();
        System.out.println();
        File library = new File("Library.txt");
        // Запись списка книг в файл (поток закрывается автоматически)
        try (FileOutputStream fos = new FileOutputStream(library);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) { // добавляем в конец документа, false перезаписываем документ
            oos.writeObject(lib1);
        } catch (IOException ex) {
            LOG.warn("Ошибка записи архива в файл");
            ex.printStackTrace();
        }





        /**
         * Чтение файла (поток закрывается автоматически)
         */
        try  (FileInputStream fis = new FileInputStream(library);
              ObjectInputStream oin = new ObjectInputStream(fis))  {

            try {
                lib1 = (Library) oin.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            lib1.printBooksList();

        } catch (IOException ex) {
            LOG.warn("Ошибка чтения");
            ex.printStackTrace();
        }

    }
}
