package com.example.hello.book.controller;


import com.example.hello.book.dto.BooksResponseDTO;
import com.example.hello.book.entity.Books;
import com.example.hello.book.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping("/books")
@Controller
public class BooksController {

    private BooksService booksService;

    @Autowired
    private BooksController (BooksService booksService){
        this.booksService = booksService;
    }

    @GetMapping
    public String getBooks(Model model) {
        List<Books> booksList = booksService.getBooks();
        model.addAttribute("bookslist", booksList);
        return "booksList";
    }

    @PostMapping
    public String uploadBooks(
            @RequestParam("title") String title,
            @RequestParam("file") MultipartFile file,
            @RequestParam("writer") String writer
    ) {
        System.out.println(title);
        booksService.uploadBooks(title, file, writer);
        return "redirect:/books";
    }

    @GetMapping("/deleteBooks/{id}")
    public String deleteBooks(@PathVariable("id") Long id) {
        booksService.deleteBooks(id);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        try {
            Books books = booksService.findById(id);
            BooksResponseDTO dto = BooksResponseDTO.from(books);
            model.addAttribute("books", dto);
            return "booksView";
        } catch (RuntimeException e) {
            return "redirect:/books";
        }
    }

    @PostMapping("/update")
    public String view(@RequestParam("id") Long id,
                       @RequestParam("title") String title,
                       @RequestParam("file") MultipartFile file,
                       @RequestParam("writer") String writer,
                       Model model) {
        try {
            Books books = booksService.updateBooks(id,title,file,writer);
            BooksResponseDTO dto = BooksResponseDTO.from(books);
            model.addAttribute("books", dto);
            return "booksView";
        } catch (RuntimeException e) {
            return "redirect:/books";
        }
    }
}
