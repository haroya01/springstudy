package com.example.hello.book.repository;
import com.example.hello.book.entity.Books;

import java.util.List;
import java.util.Optional;

public interface NotOrmBooksRepository {
    List<Books> findAll();
    Optional<Books> findById(Long id);
    void save(Books books);
    void delete(Books books);
}
