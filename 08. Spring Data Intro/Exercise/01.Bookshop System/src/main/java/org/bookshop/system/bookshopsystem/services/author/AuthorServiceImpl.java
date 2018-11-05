package org.bookshop.system.bookshopsystem.services.author;

import org.bookshop.system.bookshopsystem.models.entities.Author;
import org.bookshop.system.bookshopsystem.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
}
