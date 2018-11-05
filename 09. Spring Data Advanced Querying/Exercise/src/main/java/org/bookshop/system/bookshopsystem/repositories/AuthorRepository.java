package org.bookshop.system.bookshopsystem.repositories;

import org.bookshop.system.bookshopsystem.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a INNER JOIN a.books b WHERE b.releaseDate <= ?1")
    List<Author> findAllAuthorsWithBooksBefore(Date date);

    @Query("SELECT a FROM Author a order by a.books.size DESC")
    List<Author> findAllAuthorsOrderByCountOfBooks();

    List<Author> findAllByFirstNameEndsWith(String str);

    @Query("SELECT a from Author AS a join a.books As b group by a.id order by sum(b.copies)DESC ")
    List<Author> getAllAuthorsOrderedByTotalCopiesOfBooks();

    @Procedure(name = "usp_select_count_of_books_by_author", outputParameterName = "res")
    int getAuthorBookCountProcedure(@Param("first_name_par") String firstName, @Param("last_name_par") String lastName);
}
