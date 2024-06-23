package com.example.hello.book.repository;

import com.example.hello.book.entity.Books;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BooksRepositoryImpl implements NotOrmBooksRepository {


    private final JdbcTemplate jdbcTemplate;

    public BooksRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class BooksRowMapper implements RowMapper<Books> {
        @Override
        public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
            Books books = new Books();
            books.setId(rs.getLong("id"));
            books.setTitle(rs.getString("title"));
            books.setFile(rs.getBytes("file"));
            books.setWriter(rs.getString("writer"));
            return books;
        }
    }

    @Override
    public List<Books> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", new BooksRowMapper());
    }

    @Override
    public Optional<Books> findById(Long id) {
        List<Books> results = jdbcTemplate.query("SELECT * FROM books WHERE id = ?", new Object[]{id}, new BooksRowMapper());
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public void save(Books books) {
        if (books.getId() == null) {
            jdbcTemplate.update("INSERT INTO books (title, file, writer) VALUES (?, ?, ?)",
                    books.getTitle(), books.getFile(), books.getWriter());
        } else {
            jdbcTemplate.update("UPDATE books SET title = ?, file = ?, writer = ? WHERE id = ?",
                    books.getTitle(), books.getFile(), books.getWriter(), books.getId());
        }
    }

    @Override
    public void delete(Books books) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", books.getId());
    }
}

