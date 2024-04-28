package com.example.hello.book.service;

import com.example.hello.book.entity.Books;
import com.example.hello.book.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(final BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Transactional(readOnly = true)
    public List<Books> getBooks() {
      List<Books> books = booksRepository.findAll();
        return books;
    }

    @Transactional
    public void uploadBooks(String title, MultipartFile file, String writer) {
        try {
            byte[] fileBytes = file.getBytes();
            Books books = Books.from(title, fileBytes, writer);
            booksRepository.save(books);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void deleteBooks(Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 도서가 없습니다"));
        booksRepository.delete(books);
    }

    @Transactional(readOnly = true)
    public Books findById(Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 도서가 없습니다"));
        return books;
    }

    @Transactional
    public Books updateBooks(Long id, String title, MultipartFile file, String writer) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 도서가 없습니다"));
        try {
            byte[] fileBytes = file.getBytes();
            books.update(title, fileBytes, writer);
            booksRepository.save(books);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return books;
    }
}

