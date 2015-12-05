package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    Author findByFirstNameAndLastName(String firstName, String lastName);
}
