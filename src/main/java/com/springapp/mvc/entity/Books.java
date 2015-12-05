package com.springapp.mvc.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String genre;

    @Column
    private String description;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthors(Author author){
        authors.add(author);
    }

    public Books() {
    }

    public Books(String name) {
        this.name = name;
    }

    public Books(String genre, String description, String name) {
        this.genre = genre;
        this.description = description;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Books)) return false;
        Books books = (Books) o;
        return Objects.equal(getId(), books.getId()) &&
                Objects.equal(getGenre(), books.getGenre()) &&
                Objects.equal(getDescription(), books.getDescription()) &&
                Objects.equal(getName(), books.getName()) &&
                Objects.equal(getAuthors(), books.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getGenre(), getDescription(), getName(), getAuthors());
    }
}
