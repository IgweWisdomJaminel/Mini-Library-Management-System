package com.jaminel.minilibrary.repository;

import model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBooks,Long> {
}
