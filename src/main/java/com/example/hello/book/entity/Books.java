package com.example.hello.book.entity;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Books {

    @Id
    @Column(name = "books_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", columnDefinition = "VARCHAR(20)")
    private String title;

    @Lob
    @Column(name = "file")
    private byte[] file;

    @Column(name = "writer", columnDefinition = "VARCHAR(20)")
    private String writer;

    @Builder.Default
    @Column(name = "publish")
    private LocalDate publish = LocalDate.now();

    public static Books from(String title, byte[] fileByte, String writer) {
        return Books.builder()
                .title(title)
                .file(fileByte)
                .writer(writer)
                .build();
    }

    public void update(String title, byte[] fileByte, String writer) {
        this.title = title;
        this.file = fileByte;
        this.writer = writer;
    }
}

