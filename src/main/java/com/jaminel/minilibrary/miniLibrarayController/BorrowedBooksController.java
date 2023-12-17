package com.jaminel.minilibrary.miniLibrarayController;

import com.jaminel.minilibrary.response.ResponseHandler;
import com.jaminel.minilibrary.service.BorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BorrowedBooksController  {
    @Autowired
    BorrowedBookService borrowedBookService;


    @GetMapping("/borrowedBooks")
    public ResponseEntity<Object> getAllBorrowedBooks() {
        return  ResponseHandler.responseBuilder("found", HttpStatus.OK,borrowedBookService.getAllBorrowedBooks());

    }
    @GetMapping("/borrowedBooks/{id}")
    public ResponseEntity<Object> deletesBorrowedBook(@PathVariable long id) {
        return  ResponseHandler.responseBuilder("found", HttpStatus.OK,borrowedBookService.deleteBorrowedBook(id));

    }

    

}
