package com.springapp.mvc.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String patronymic;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday_date")
    private Calendar birthdayDate;

//    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    private Set<Books> books = new HashSet<Books>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Calendar getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Calendar birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }

    public Author() {
    }

    public Author(String firstName, String lastName, Calendar birthdayDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate;
    }

    public Author(String firstName, String lastName, String patronymic, Calendar birthdayDate, Set<Books> books){
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthdayDate = birthdayDate;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equal(getId(), author.getId()) &&
                Objects.equal(getFirstName(), author.getFirstName()) &&
                Objects.equal(getLastName(), author.getLastName()) &&
                Objects.equal(getPatronymic(), author.getPatronymic()) &&
                Objects.equal(getBirthdayDate(), author.getBirthdayDate()) &&
                Objects.equal(getBooks(), author.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getFirstName(), getLastName(), getPatronymic(), getBirthdayDate(), getBooks());
    }
}
