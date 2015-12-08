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
    BooksService booksService;

    @Test
    public void manyToManyTest(){
        Books books1 = new Books("Роман", "Роман американского гонзо-журналиста Хантера Томпсона(издан компанией Bantam Books в 1983 году)", "Проклятие Гавайев");
        Books books2 = new Books("Гонзо-журналистика", "Сборник статей американского гонзо-журналиста Хантера Томпсона. Издан в 1979 году и являлся первой из четырёх книг серии «The Gonzo Papers»", "Большая охота на акул");
        Books books3 = new Books("Гонзо-журналистика", "Роман американского журналиста Х.Томпсона. В 1998 году роман был экранизирован Терри Гиллиамом, главную роль в фильме исполнил Джонни Депп", "Страх и отвращение в Лас-Вегасе");
        Books books4 = new Books("Роман", "Произведение писателя бит-поколения Уильяма Берроуза, которое открывает последнюю трилогию Берроуза, в которую также вошли романы «Пространство мёртвых дорог» и «Западные земли»", "Города красной ночи");
        Books books5 = new Books("Роман", "Роман американского писателя Уильяма Берроуза. Впервые опубликован на английском языке в 1959 году в парижском издательстве Olympia Press", "Голый завтрак");
        Books books6 = new Books("Роман", "Роман Уильяма Берроуза, вторая часть его трилогии, куда также входят книги «Города красной ночи» и «Западные земли».", "Пространство мёртвых дорог");
        Books books7 = new Books("Новелла", "Автобиографическая новелла Уильяма Берроуза. Выпущена в 1986 году издательством Grenfell Press тиражом в 133 экземпляра и иллюстрирована Брайоном Гайсином", "Кот внутри");

        Set<Books> booksSet1 = new HashSet<>();
        booksSet1.add(books1);
        booksSet1.add(books2);
        booksSet1.add(books3);

        Set<Books> booksSet2 = new HashSet<>();
        booksSet2.add(books4);
        booksSet2.add(books5);
        booksSet2.add(books6);
        booksSet2.add(books7);

        Author author1 = new Author("Хантер", "Стоктон", "Томпсон",
                new GregorianCalendar(1937, Calendar.JULY, 18), booksSet1);
        Author author2 = new Author("Уильям", "Сьюард", "Берроуз",
                new GregorianCalendar(1914, Calendar.FEBRUARY, 5), booksSet2);

        authorService.addOrEditAuthor(author1);
        authorService.addOrEditAuthor(author2);
    }

    //@Test
    public void deleteBookTest(){
        Books book = booksService.findByName("Маллой");
        List<Author> authorsList = authorService.findAll();
        for(Author a : authorsList){
            //Удаляет из author_books
            a.getBooks().remove(book);
        }
        //Удаляет из books
        booksService.delete(book.getId());
    }

    //@Test
    public void deleteAllAuthorTest(){
        authorService.deleteAll();
    }

    //@Test
    public void deleteAllBooksTest(){
        booksService.deleteAll();
    }

    //@Test
    public void getAuthorBooksTest(){
        Author author = authorService.findOne(34);
        Set<Books> booksSet = author.getBooks();

        for(Books b : booksSet){
            System.out.println(b.getName() + b.getGenre());
        }
    }

    //@Test
    public void addOneBookTest(){
        Books book = new Books("Новелла", "Автобиографическая новелла Уильяма Берроуза. Выпущена в 1986 году издательством Grenfell Press тиражом в 133 экземпляра и иллюстрирована Брайоном Гайсином", "Кот внутри");
        Author bookAuthor = authorService.findOne(36);

//        Set<Author> bookAuthors = new HashSet<>();
//        bookAuthors.add(bookAuthor);
//        book.setAuthors(bookAuthors);
//        booksService.addOrEditBook(book);
        bookAuthor.getBooks().add(book);
        authorService.addOrEditAuthor(bookAuthor);
    }
}
