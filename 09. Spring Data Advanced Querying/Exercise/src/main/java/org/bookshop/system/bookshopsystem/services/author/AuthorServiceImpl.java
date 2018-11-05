package org.bookshop.system.bookshopsystem.services.author;

import org.bookshop.system.bookshopsystem.models.entities.Author;
import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.bookshop.system.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public void save(List<Author> authors) {
        this.authorRepository.saveAll(authors);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public List<Author> getAllWithBooksBefore(Date date) {
        return this.authorRepository.findAllAuthorsWithBooksBefore(date);
    }

    @Override
    public List<Author> getAllAuthorsOrderByCountOfBooks() {
        return this.authorRepository.findAllAuthorsOrderByCountOfBooks();
    }

    @Override
    public List<String> getAllAuthorsNamesWhereFirstNameEndsWith(String str) {
        return this.authorRepository.findAllByFirstNameEndsWith(str)
                .stream()
                .map(a-> String.format("%s %s",a.getFirstName(),a.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllAuthorsAndCountOfTheirBooksCopies() {
        return this.authorRepository.getAllAuthorsOrderedByTotalCopiesOfBooks()
                .stream()
                .map(a-> String.format("%s %s - %d",a.getFirstName(),a.getLastName(),
                        a.getBooks().stream().mapToInt(Book::getCopies).sum()))
                .collect(Collectors.toList());
    }

    @Override
    public int getAuthorsBooksCountFromProcedure(String firstName, String lastName) {
        return this.authorRepository.getAuthorBookCountProcedure(firstName,lastName);
    }
}
