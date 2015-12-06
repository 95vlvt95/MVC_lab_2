package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Books;
import com.springapp.mvc.repository.BooksRepository;
import com.springapp.mvc.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Repository
@Transactional
public class BooksServiceImpl implements BooksService{

    @Autowired
    BooksRepository booksRepository;

    public Books findOne(long id) {
        return booksRepository.findOne(id);
    }

    public List<Books> findAll() {
        return (List<Books>) booksRepository.findAll();
    }

    public Books findByName(String name) {
        return booksRepository.findByName(name);
    }

    public Books addOrEditBook(Books book) {
        return booksRepository.save(book);
    }

/*
    public void saveAll(Iterable<Books> books) {
        booksRepository.save(books);
    }
*/

    public void delete(long id) {
        booksRepository.delete(id);
    }

    public void deleteAll() {
        booksRepository.deleteAll();
    }
}
