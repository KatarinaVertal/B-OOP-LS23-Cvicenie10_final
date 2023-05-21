package sk.stuba.fei.uim.oop.Books;

import lombok.Getter;

@Getter
public class BookResponse {
    private Long id;
    private String name;
    private String author;
    private Integer pages;

    public BookResponse(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.pages = book.getPages();
    }
}
