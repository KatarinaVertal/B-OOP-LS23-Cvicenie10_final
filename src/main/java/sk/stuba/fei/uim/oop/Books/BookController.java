package sk.stuba.fei.uim.oop.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return this.bookService.getAll().stream().map(book -> new BookResponse(book)).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> getBook(@PathVariable("id") Long bookId){
        Book book = this.bookService.getById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(new BookResponse(book));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createBook(@RequestBody BookRequest body) {
        return new ResponseEntity<Long>(this.bookService.createBook(body).getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long bookId, @RequestBody BookRequest body) {
        Book book = this.bookService.getById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        this.bookService.updateBook(book, body);
        return ResponseEntity.ok(new BookResponse(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable("id") Long bookId) {
        Book book = this.bookService.getById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        this.bookService.deleteBook(book);
        return ResponseEntity.ok(new BookResponse(book));
    }




}
