package com.springapp.mvc;

import com.springapp.mvc.entity.Author;
import com.springapp.mvc.entity.Books;
import com.springapp.mvc.service.AuthorService;
import com.springapp.mvc.service.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class MyTest {

    @Autowired
    AuthorService authorService;

    @Autowired
    BooksService bookService;

    //@Test
    public void manyToManyTest(){
        Books books1 = new Books("Комедия", "Комедия в пяти действиях русского писателя Николая Васильевича Гоголя", "Ревизор");
        Books books2 = new Books("Комедия", "Пьеса Николая Васильевича Гоголя. Написана в 1833—1835 гг, опубликована в 1842 году.", "Женитьба");
        Books books3 = new Books("Драма", "Является вторым опубликованным на английском языке романом Сэмюэла Беккета и поворотной точкой в творчестве писателя.", "Уотт");
        Books books4 = new Books("Драма", "Прозаическое произведение ирландского писателя Сэмюэла Беккета.", "Моллой");
        Books books5 = new Books("Драма", "Третье по счету крупное прозаическое произведение ирландского писателя Сэмюэля Беккета и первый опубликованный роман.", "Мерфи");
        Books books6 = new Books("Драма", "Первое крупное прозаическое произведение ирландского писателя Сэмюэля Беккета.", "Мечты о женщинах, красивых и так себе");

        Set<Books> booksSet1 = new HashSet<>();
        booksSet1.add(books1);
        booksSet1.add(books2);

        Set<Books> booksSet2 = new HashSet<>();
        booksSet2.add(books3);
        booksSet2.add(books4);
        booksSet2.add(books5);
        booksSet2.add(books6);

        Author author1 = new Author("Гоголь", "Николай", "Василиевич",
                new GregorianCalendar(1809, Calendar.MARCH, 20), booksSet1);
        Author author2 = new Author("Сэмюэл", "Баркли", "Беккет",
                new GregorianCalendar(1906, Calendar.APRIL, 13), booksSet2);

        authorService.addOrEditAuthor(author1);
        authorService.addOrEditAuthor(author2);
    }

    //@Test
    public void deleteBookTest(){
        Books book = bookService.findByName("Маллой");
        List<Author> authorsList = authorService.findAll();
        for(Author a : authorsList){
            //Удаляет из author_books
            a.getBooks().remove(book);
        }
        //Удаляет из books
        bookService.delete(book.getId());
    }

    @Test
    public void deleteAllAuthorTest(){
        authorService.deleteAll();
    }

    //@Test
    public void deleteAllBooksTest(){
        bookService.deleteAll();
    }
}
