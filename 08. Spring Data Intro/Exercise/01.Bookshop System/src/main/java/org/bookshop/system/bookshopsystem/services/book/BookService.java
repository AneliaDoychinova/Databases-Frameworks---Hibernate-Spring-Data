package org.bookshop.system.bookshopsystem.services.book;

import org.bookshop.system.bookshopsystem.models.entities.Book;

import java.util.Date;
import java.util.List;

public interface BookService {
    void save(Book book);
    void save(List<Book> books);
    List<String> allTitlesAfterYear(Date year);
    List<Book> getAllBooksByName(String firstName, String lastName);
}
