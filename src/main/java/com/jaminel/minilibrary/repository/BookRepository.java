package com.jaminel.minilibrary.repository;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    public Book findBookByTitle(String title);
    public Book findBookByIsbn(String isbn);

    public Book findBookByBookId(Long id);
   public List<Book>findBooksByTitle(String back);

    public Book findBookByAuthor(String author);

    public List<Book> getAllBook();
}
