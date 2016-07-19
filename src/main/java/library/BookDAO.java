package library;

import java.util.List;

public interface BookDAO {
    void add(Book book);
    void delete(Book book);
    void delete(long[] ids);
    List<Book> list(Genre genre);
    List<Book> list(String pattern);
}
