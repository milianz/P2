package org.milianz.p2.Service.ServiceImplementation;

import org.milianz.p2.Domain.Entities.Book;
import org.milianz.p2.Repository.iBookRepository;
import org.milianz.p2.Service.iBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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


}
