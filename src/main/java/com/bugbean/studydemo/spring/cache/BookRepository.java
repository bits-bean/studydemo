package com.bugbean.studydemo.spring.cache;

public interface BookRepository {

    Book getByIsbn(String isbn);

}