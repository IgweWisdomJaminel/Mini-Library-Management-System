package com.jaminel.minilibrary.service;

import com.jaminel.minilibrary.exceptions.MiniLibraryNotFoundException;
import com.jaminel.minilibrary.repository.BookRepository;
import com.jaminel.minilibrary.repository.BorrowedBookRepository;
import com.jaminel.minilibrary.repository.UserRepository;
import model.Book;
import model.BorrowedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowedBookRepository borrowedBooksRepository;
    @Autowired
    UserRepository userRepository;


    @CachePut(value = "books", key = "#book.bookId")
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }


    @CacheEvict(value = "books", key = "#bookId")
    public void deleteBookid(long bookId) {
        Book book = findBookById(bookId);
            if (book == null) {
                throw new MiniLibraryNotFoundException("Not found");
            }
        bookRepository.deleteById(bookId);
    }


    @CachePut(value = "borrowedBooks", key = "#userId + #bookTitle")
    public Object borrowBook(String BookTitle, long userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new MiniLibraryNotFoundException("user not found");
        }
        BorrowedBooks borrowedBooks = new BorrowedBooks();
        Book bookTitle = bookRepository.findBookByTitle(BookTitle);
        borrowedBooks.setUserId(userId);
        borrowedBooks.setBookId(bookTitle.getBookId());
        borrowedBooks.setIsbn(bookTitle.getIsbn());
        borrowedBooks.setAuthor(bookTitle.getAuthor());
        borrowedBooksRepository.save(borrowedBooks);
        bookRepository.deleteBookByTitle(BookTitle);

        return null;
    }


    @Cacheable(value = "books", key = "#bookId")
    public Book findBookById(Long bookId) {
        return bookRepository.findBookByBookId(bookId);
    }


    @Cacheable(value = "books", key = "#title")
    public Book findbookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }
    @Cacheable(value = "books", key = "#title")
    public List<Book> findbooksByTitle(String title){
        return bookRepository.findBooksByTitle(title);
    }


    @Cacheable(value = "books", key = "#author")
    public Book findBookByAuthor(String author) {

        return bookRepository.findBookByAuthor(author);
    }


    @Cacheable(value = "books", key = "#isbn")
    public Book findBookByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn);
    }


    @Cacheable(value = "books")
    public List<Book> getBookList(){

        return bookRepository.getAllBook();
    }

}
