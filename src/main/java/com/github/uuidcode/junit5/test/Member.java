package com.github.uuidcode.junit5.test;

public class Member {
    private Author author;

    public Author getAuthor() {
        return this.author;
    }

    public Member setAuthor(Author author) {
        this.author = author;
        return this;
    }
}
