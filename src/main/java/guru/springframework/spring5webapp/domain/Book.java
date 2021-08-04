package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String bookSN;

    @ManyToMany
    @JoinTable(name = "AUTHOR_BOOK", joinColumns = @JoinColumn(name = "BOOK_ID")
            , inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String title, String bookSN) {
        this.title = title;
        this.bookSN = bookSN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        this.bookSN = bookSN;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bookSN='" + bookSN + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
