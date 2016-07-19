package library;

import javax.persistence.*;

@Entity
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;

    private String name;
    private String writer;
    private String description;

    public Book() {}

    public Book(Genre genre, String name, String writer, String description)
    {
        this.genre = genre;
        this.name = name;
        this.writer = writer;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
