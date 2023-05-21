package sk.stuba.fei.uim.oop.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book createBook(BookRequest body) {
        Book book = new Book();
        book.setName(body.getName());
        book.setAuthor(body.getAuthor());
        book.setPages(body.getPages());
        this.bookRepository.save(book);
        return book;
    }

    @Override
    public Book getById(Long bookId) {
        Book b = this.bookRepository.findBookById(bookId);
        return b;
    }

    @Override
    public void updateBook(Book book, BookRequest body) {
        if (body.getName() != null){
            book.setName(body.getName());
        }
        if (body.getAuthor() != null){
            book.setAuthor(body.getAuthor());
        }
        if (body.getPages() != null){
            book.setPages(body.getPages());
        }
        this.bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        this.bookRepository.delete(book);
    }


}
