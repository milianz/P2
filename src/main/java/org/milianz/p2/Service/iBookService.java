package org.milianz.p2.Service;

import org.milianz.p2.Domain.DTOs.CreateBookDTO;
import org.milianz.p2.Domain.Entities.Book;

import java.util.List;
import java.util.UUID;

public interface iBookService {

    Book findBookByIsbn(String isbn);
    List<Book> findByAuthor(String author);
    List<Book> findByLanguage(String language);
    List<Book> findByGenre(String genre);
    List<Book> findByPagesBetween(Integer min, Integer max);
    void createBook(CreateBookDTO createBookDTO);
    void updateBookLenguage(String isbn, String newLanguage);
    void updateBookTitle(String isbn, String newTitle);
    void deleteBook(String isbn);
}
