package org.bookshop.system.bookshopsystem.services.book;

import org.bookshop.system.bookshopsystem.models.ReducedBookImpl;
import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.bookshop.system.bookshopsystem.models.enums.AgeRestriction;
import org.bookshop.system.bookshopsystem.models.enums.EditionType;
import org.bookshop.system.bookshopsystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public List<String> getAllBooksByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.getAllByAgeRestriction(ageRestriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksByEditionTypeAndCopies(EditionType editionType, Integer copies) {
        return this.bookRepository.getAllByEditionTypeAndCopiesLessThan(editionType,copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksWithPriceBiggerAndLowerThanGiven(BigDecimal biggerPrice, BigDecimal lowerPrice) {
        return this.bookRepository.getAllByPriceGreaterThanOrPriceLessThan(biggerPrice,lowerPrice)
                .stream()
                .map(b-> String.format("%s - $%.2f%n",b.getTitle(),b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTitlesByReleaseDateIsYearNot(int year) {
        return this.bookRepository.getAllByReleaseDateYearIsNot(year)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksReleasedBeforeDate(Date date) {
        return this.bookRepository.getAllByReleaseDateBefore(date)
                .stream()
                .map(b -> String.format("%s - %s - $%.2f",b.getTitle(),b.getEditionType().name(),b.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesWhereContains(String str) {
        return this.bookRepository.getAllByTitleIgnoreCaseContaining(str)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesWhereAuthorsLastNameStartsWith(String str) {
        return this.bookRepository.getAllByAuthorLastNameStartingWith(str)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public int getCountOfBooksWithTitleLongerThan(int len) {
        return this.bookRepository.getAllByTitleLengthLongerThan(len).size();
    }

    @Override
    public List<ReducedBookImpl> getAllBooksByTitle(String title) {
       return this.bookRepository.getAllByTitleIs(title)
               .stream()
               .map(b->new ReducedBookImpl(b.getTitle(),b.getEditionType(),b.getAgeRestriction(),b.getPrice()))
               .collect(Collectors.toList());
    }

    @Override
    public int increaseBookCopies(int copies, Date date) {
        return this.bookRepository.increaseBooksCopiesWithGivenNumber(copies,date);
    }

    @Override
    public int deleteBooksWithCopiesLessThan(int copies) {
        return this.bookRepository.deleteBookByCopiesLessThan(copies);
    }

}
