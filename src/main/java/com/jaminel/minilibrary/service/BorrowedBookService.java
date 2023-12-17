package com.jaminel.minilibrary.service;

import com.jaminel.minilibrary.repository.BorrowedBookRepository;
import com.jaminel.minilibrary.repository.UserRepository;
import model.BorrowedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    BookService bookService;
    BorrowedBookRepository borrowedBookRepository;

    public List<BorrowedBooks> getAllBorrowedBooks(){

        return   borrowedBookRepository.findAll();
    }

    public String deleteBorrowedBook(long bookId){
        borrowedBookRepository.deleteById(bookId);
        return "Book deleted";
    }




}