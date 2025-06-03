package org.milianz.p2.Repository;

import org.milianz.p2.Domain.Entities.Book;

import java.util.UUID;

public interface iBookRepository extends iGenericRepository<Book, UUID> {


    Book findByAuthor(String author);
    Book findByLanguage(String lenguage);
    Book findByGenre(String genre);
    Book findByIsbn(String isbn);
    Book findByPagesBetween(Integer min, Integer max);
}
