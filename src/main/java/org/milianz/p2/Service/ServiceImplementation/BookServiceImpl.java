package org.milianz.p2.Service.ServiceImplementation;

import lombok.RequiredArgsConstructor;
import org.milianz.p2.Domain.DTOs.CreateBookDTO;
import org.milianz.p2.Domain.Entities.Book;
import org.milianz.p2.Repository.iBookRepository;
import org.milianz.p2.Service.iBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements iBookService {

    @Autowired
    private iBookRepository bookRepository;
    @Override
    public Book findBookByIsbn(String isbn) {
        Book book = new Book();
        book = bookRepository.findByIsbn(isbn);
        return book;
    }

    @Override
    public List<Book> findByAuthor(String authorName) {

        return List.of(bookRepository.findByAuthor(authorName));
    }

    @Override
    public List<Book> findByLanguage(String language) {
        return List.of(bookRepository.findByLanguage(language));
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return List.of(bookRepository.findByGenre(genre));
    }

    @Override
    public List<Book> findByPagesBetween(Integer min, Integer max) {
        return List.of(bookRepository.findByPagesBetween(min, max));
    }

    @Override
    public void createBook(CreateBookDTO createBookDTO) {
        Book book = new Book();
        book.setTitle(createBookDTO.getTitle());
        book.setAuthor(createBookDTO.getAuthor());
        book.setIsbn(createBookDTO.getIsbn());
        book.setPublicationYear(createBookDTO.getPublicationYear());
        book.setLanguage(createBookDTO.getLanguage());
        book.setPages(createBookDTO.getPages());
        book.setGenre(createBookDTO.getGenre());

        bookRepository.save(book);
    }

    @Override
    public void updateBookLenguage(String isbn, String newLanguage) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            book.setLanguage(newLanguage);
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("El libro con:" + isbn + " no se pudo encontrar.");
        }

    }

    @Override
    public void updateBookTitle(String isbn, String newTitle) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            book.setTitle(newTitle);
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("El libro con:" + isbn + " no se pudo encontrar.");
        }

    }

    @Override
    public void deleteBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        } else {
            throw new IllegalArgumentException("El libro con:" + isbn + " no se pudo encontrar.");
        }
    }
}
