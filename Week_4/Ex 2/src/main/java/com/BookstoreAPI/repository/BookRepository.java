package com.BookstoreAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.BookstoreAPI.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
    
}