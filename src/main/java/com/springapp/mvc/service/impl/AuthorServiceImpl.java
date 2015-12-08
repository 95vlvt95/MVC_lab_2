package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Author;
import com.springapp.mvc.repository.AuthorRepository;
import com.springapp.mvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("authorService")
@Repository
@Transactional
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    public Author findOne(long id) {
        return authorRepository.findOne(id);
    }

    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    public List<Author> findByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName);
    }

    public List<Author> findByLastName(String lastName) {
        return authorRepository.findByLastName(lastName);
    }

    @Override
    public Author findByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }


    public Author addOrEditAuthor(Author author) {
        return authorRepository.save(author);
    }

/*
    public void saveAll(Iterable<Author> authors){
        authorRepository.save(authors);
    }
*/

    public void delete(long id) {
        authorRepository.delete(id);
    }

    public void deleteAll() {
        authorRepository.deleteAll();
    }
}
