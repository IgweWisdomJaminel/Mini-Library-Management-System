package com.jaminel.minilibrary.service;

import com.jaminel.minilibrary.repository.BorrowedBookRepository;
import com.jaminel.minilibrary.repository.UserRepository;
import model.BorrowedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    BookService bookService;
    BorrowedBookRepository borrowedBookRepository;
    @Cacheable("BorrowedBooks")
    public List<BorrowedBooks> getAllBorrowedBooks(){

        return   borrowedBookRepository.findAll();
    }
     @CacheEvict(value = "BorrowedBooks",allEntries = true)
    public String deleteBorrowedBook(long bookId){
        borrowedBookRepository.deleteById(bookId);
        return "Book deleted";
    }




}