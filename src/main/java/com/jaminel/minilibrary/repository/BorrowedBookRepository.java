package com.jaminel.minilibrary.repository;

import model.Book;
import model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBooks,Long> {
}
