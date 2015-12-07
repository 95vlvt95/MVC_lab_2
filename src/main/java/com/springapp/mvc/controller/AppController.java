package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Author;
import com.springapp.mvc.entity.Books;
import com.springapp.mvc.service.AuthorService;
import com.springapp.mvc.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BooksService booksService;

//    @RequestMapping(value = "/")
//    public String testPage(){
//        return "mypage";
//    }
//
//    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
//    public String listAuthorBooks(ModelMap model){
//        List<Author> authorList = authorService.findByFirstName("Гоголь");
//        model.addAttribute("author1", authorList);
//        return "mypage";
//    }

    @RequestMapping(value = "/")
    public String listBooks(ModelMap model){
        List<Books> booksList = booksService.findAll();
        List<Author> authorsList = authorService.findAll();

        model.addAttribute("books", booksList);
        model.addAttribute("authors", authorsList);
        return "mypage";
    }

    @RequestMapping(value = {"/{authorId}"})
    public String authorBooks(@PathVariable long authorId, ModelMap model){
        List<Books> booksList = booksService.findAll();
        List<Author> authorsList = authorService.findAll();
        model.addAttribute("books", booksList);
        model.addAttribute("authors", authorsList);

        Author author = authorService.findOne(authorId);
        Set<Books> authorBooksSet = author.getBooks();
        model.addAttribute("selectedAuthor", author);
        model.addAttribute("authorBooks", authorBooksSet);

        return "mypage";
    }
}
