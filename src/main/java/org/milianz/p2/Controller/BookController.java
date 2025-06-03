package org.milianz.p2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.milianz.p2.Domain.DTOs.CreateBookDTO;
import org.milianz.p2.Service.iBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin +
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private iBookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Void> createBook(@RequestBody CreateBookDTO createBookDTO) {
        try {
            bookService.createBook(createBookDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/{isbn}")
    public ResponseEntity<Void> findBookByIsbn(@PathVariable("isbn") String isbn) {
        try {
            bookService.findBookByIsbn(isbn);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{author}")
    public ResponseEntity<Void> findByAuthor(@PathVariable("author") String authorName) {
        try {
            bookService.findByAuthor(authorName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{language}")
    public ResponseEntity<Void> findByLanguage(@PathVariable("language")String language) {
        try {
            bookService.findByLanguage(language);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{genre}")
    public ResponseEntity<Void> findByGenre(@PathVariable("genre") String genre) {
        try {
            bookService.findByGenre(genre);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/deleteByIsbn")
    public ResponseEntity<Void> deleteByIsbn(@RequestParam("isbn") String isbn) {
        try {
            bookService.deleteBook(isbn);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
