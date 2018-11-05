package org.bookshop.system.bookshopsystem.repositories;

import org.bookshop.system.bookshopsystem.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> getAllByReleaseDateAfter(Date date);

    @Query("SELECT b FROM Book b where b.author.firstName =:firstName and b.author.lastName =:lastName order by " +
            "b.releaseDate DESC, b.title ASC ")
    List<Book> getAllByName(@Param("firstName") String firstName,@Param("lastName") String lastName);
}
