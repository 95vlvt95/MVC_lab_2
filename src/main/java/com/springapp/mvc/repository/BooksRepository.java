package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Long> {
}
