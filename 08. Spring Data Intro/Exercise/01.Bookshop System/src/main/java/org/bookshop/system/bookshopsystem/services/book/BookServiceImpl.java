package org.bookshop.system.bookshopsystem.services.book;

import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.bookshop.system.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void save(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public List<String> allTitlesAfterYear(Date year) {
        List<Book> books = this.bookRepository.getAllByReleaseDateAfter(year);
        List<String> titles = books.stream().map(Book::getTitle).collect(Collectors.toList());
        return titles;
    }

    @Override
    public List<Book> getAllBooksByName(String firstName, String lastName) {
        return this.bookRepository.getAllByName(firstName, lastName);
    }
}
