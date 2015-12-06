package com.springapp.mvc.service;

import com.springapp.mvc.entity.Books;

import java.util.List;

public interface BooksService {
    Books findOne(long id);
    List<Books> findAll();
    Books findByName(String name);
    Books addOrEditBook(Books book);
    //void saveAll(Iterable<Books> books);
    void delete(long id);
    void deleteAll();
}
