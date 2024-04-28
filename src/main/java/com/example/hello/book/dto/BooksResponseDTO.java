package com.example.hello.book.dto;

import com.example.hello.book.entity.Books;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Base64;


@Getter
@AllArgsConstructor
@Builder
public class BooksResponseDTO {

    private final Long id;
    private final String title;
    private final String writer;
    private final String imageData;
    private final LocalDate date;

    public static BooksResponseDTO from(Books books) {
        return BooksResponseDTO.builder()
                .id(books.getId())
                .title(books.getTitle())
                .writer(books.getWriter())
                .imageData(Base64.getEncoder().encodeToString(books.getFile()))
                .date(books.getPublish())
                .build();
    }
}