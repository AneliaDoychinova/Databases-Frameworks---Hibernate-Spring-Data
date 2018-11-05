package org.bookshop.system.bookshopsystem.services.author;

import org.bookshop.system.bookshopsystem.models.entities.Author;

import java.util.Date;
import java.util.List;

public interface AuthorService {
    void save(Author author);
    void save(List<Author> authors);

    List<Author> getAllAuthors();
    List<Author> getAllWithBooksBefore(Date date);
    List<Author> getAllAuthorsOrderByCountOfBooks();
}
