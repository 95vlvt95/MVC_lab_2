package com.springapp.mvc.service;

import com.springapp.mvc.entity.Author;

import java.util.List;

public interface AuthorService {
    Author findOne(long id);
    List<Author> findAll();
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    Author addOrEditAuthor(Author author);
    //void saveAll(Iterable<Author> authors);
    void delete(long id);
    void deleteAll();
}
