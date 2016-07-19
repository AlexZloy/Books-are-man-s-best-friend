package library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public void delete(long[] ids) {
        Book c;
        for (long id : ids) {
            c = entityManager.getReference(Book.class, id);
            entityManager.remove(c);
        }
    }

    @Override
    public List<Book> list(Genre genre) {
        Query query;

        if (genre != null) {
            query = entityManager.createQuery("SELECT c FROM Book c WHERE c.genre = :genre", Book.class);
            query.setParameter("genre", genre);
        } else {
            query = entityManager.createQuery("SELECT c FROM Book c", Book.class);
        }

        return (List<Book>) query.getResultList();
    }

    @Override
    public List<Book> list(String pattern) {
        Query query = entityManager.createQuery("SELECT c FROM Book c WHERE c.name LIKE :pattern", Book.class);
        query.setParameter("pattern", "%" + pattern + "%");
        return (List<Book>) query.getResultList();
    }
}