package co.saimyr.bookstore.domain;

import static co.saimyr.bookstore.domain.validator.ArgumentsValidator.validateNotNullOrEmpty;

public class BookDomain {
    private int isbn;
    private String name;
    private String author;
    private String publisher;
    private String genre;

    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        validateNotNullOrEmpty(name,"el nombre del libro no puede ser vacio o nulo");
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        validateNotNullOrEmpty(author,"el autor del libro no puede ser vacio o nulo");
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        validateNotNullOrEmpty(publisher,"la editorial del libro no puede ser vacio o nulo");
        this.publisher = publisher;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        validateNotNullOrEmpty(genre,"el genero del libro no puede ser vacio o nulo");
        this.genre = genre;
    }
}
