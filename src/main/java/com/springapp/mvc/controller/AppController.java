package com.springapp.mvc.controller;

import com.springapp.mvc.entity.Author;
import com.springapp.mvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listAuthorBooks(ModelMap model){
        List<Author> authorList = authorService.findByFirstName("Гоголь");
        model.addAttribute("author1", authorList);
        return "mypage";
    }
}
