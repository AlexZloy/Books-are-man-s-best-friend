package library;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Genre")
public class Genre {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy="genre", cascade=CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();

    public Genre() {}

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
