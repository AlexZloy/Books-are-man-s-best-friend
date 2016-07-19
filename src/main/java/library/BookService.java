package library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private GenreDAO genreDAO;

    @Transactional
    public void addBook(Book book) {
        bookDAO.add(book);
    }

    @Transactional
    public void addGenre(Genre genre) {
      genreDAO.add(genre);
    }

    @Transactional
    public void deleteBook(long[] ids) {
        bookDAO.delete(ids);
    }

    @Transactional(readOnly=true)
    public List<Genre> listGenre() {
        return genreDAO.list();
    }

    @Transactional(readOnly=true)
    public List<Book> listBooks(Genre genre) {
        return bookDAO.list(genre);
    }

    @Transactional(readOnly=true)
    public Genre findGenre(long id) {
        return genreDAO.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Book> searchBooks(String pattern) {
        return bookDAO.list(pattern);
    }
}
