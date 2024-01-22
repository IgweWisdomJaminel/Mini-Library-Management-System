package com.jaminel.minilibrary.miniLibrarayController;

import com.jaminel.minilibrary.response.ResponseHandler;
import com.jaminel.minilibrary.service.BookService;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Books")
public class BookController  {

    @Autowired
    BookService bookService;


    @GetMapping("/borrowedBook/{bookId}/{@PathVariable")
    public ResponseEntity<Object>borrowBook(@PathVariable Long bookId, @PathVariable String title){
        return ResponseHandler.responseBuilder("found",HttpStatus.OK,bookService.borrowBook(title,bookId));
    }

    @GetMapping("/findBookTitle/{title}")
    public ResponseEntity<Object> findBookByTitle(@PathVariable String title) {
        return ResponseHandler.responseBuilder("found", HttpStatus.OK,bookService.findbooksByTitle(title));
    }

    @GetMapping("/findBookIsbn/{isbn}")
    public ResponseEntity<Object> findBookByIsbn(@PathVariable String isbn) {
        return ResponseHandler.responseBuilder("found", HttpStatus.OK,bookService.findBookByIsbn(isbn));
    }

    @GetMapping("/findBookBookid/{id}")
    public ResponseEntity<Object> findBookByBookId(@PathVariable Long bookId) {
        return ResponseHandler.responseBuilder("found", HttpStatus.OK,bookService.findBookById(bookId));
    }

    @GetMapping("/findBookTitle/{title}")
    public ResponseEntity<Object> findBooksByTitle(@PathVariable String title) {
        return ResponseHandler.responseBuilder("found", HttpStatus.OK,bookService.findbooksByTitle(title));
    }

    @GetMapping("/findBookAuthor/{author}")
    public ResponseEntity<Object> findBooksByAuthor(@PathVariable String author) {
        return ResponseHandler.responseBuilder("found", HttpStatus.OK,bookService.findBookByAuthor(author));
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<Object>getAllBook() {
        return ResponseHandler.responseBuilder("found", HttpStatus.OK,bookService.getBookList());
    }

    @PutMapping("/addBook")
    public ResponseEntity<Object>addBooks(Book book){

       return ResponseHandler.responseBuilder("found",HttpStatus.OK,bookService.addBook(book));
    }
}
