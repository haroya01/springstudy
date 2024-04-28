package com.example.hello.book.entity;

public class Board {
    private int idx;
    private String title;
    private String content;
    private String writer;
    private String indate;
    private int count;

    // 기본 생성자
    public Board() {
    }

    // getter and setter for idx
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    // getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // getter and setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // getter and setter for writer
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    // getter and setter for indate
    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    // getter and setter for count
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

