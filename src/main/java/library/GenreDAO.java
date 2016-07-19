package library;

import java.util.List;

public interface GenreDAO {
    void add(Genre genre);
    Genre findOne(long id);
    List<Genre> list();
}
