package sk.stuba.fei.uim.oop.Books;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    Book createBook(BookRequest body);

    Book getById(Long bookId) ;

    void updateBook(Book book, BookRequest body);

    void deleteBook(Book book);

}
