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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    AuthorService authorService;

    @Autowired
    BooksService booksService;

    @RequestMapping(value = "/")
    public String listBooks(ModelMap model){
        List<Books> booksList = booksService.findAll();
        List<Author> authorsList = authorService.findAll();

        model.addAttribute("books", booksList);
        model.addAttribute("authors", authorsList);
        return "mypage";
    }

    @RequestMapping(value = {"/", "/{authorId}"},
                    params = {"name", "genre", "desc", "authorId"},
                    method = RequestMethod.POST)
    public String addBook(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "genre", required = true) String genre,
                          @RequestParam(value = "desc", required = true) String desc,
                          @RequestParam(value = "authorId", required = true) long authorId,
                          ModelMap model){
        Books bookToAdd = new Books(genre, desc, name);
        Author bookAuthor = authorService.findOne(authorId);
        bookAuthor.getBooks().add(bookToAdd);
        authorService.addOrEditAuthor(bookAuthor);

        String successMessage = "Книга успешно добавлена";
        model.addAttribute("success", successMessage);

        return "success";
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

    @RequestMapping(value = {"/delete-book-{bookId}"})
    public String selectBookToDelete(@PathVariable long bookId,
                                     ModelMap model){
        Books book = booksService.findOne(bookId);
        model.addAttribute("bookToDelete", book);

        return "deleteitem";
    }

    //переделать чуток
    @RequestMapping(value = {"/delete-book-{bookId}"},
                    params = {"delete-btn"},
                    method = RequestMethod.GET)
    public String deleteBook(@RequestParam(value = "delete-btn", required = true) String s,
                             @PathVariable long bookId,
                             ModelMap model){

        Books book = booksService.findOne(bookId);
        List<Author> authors = authorService.findAll();
        for(Author a : authors){
            a.getBooks().remove(book);
        }
        booksService.delete(bookId);

        String successMessage = "Книга успешно удалена";
        model.addAttribute("success", successMessage);

        return "success";
    }
}
