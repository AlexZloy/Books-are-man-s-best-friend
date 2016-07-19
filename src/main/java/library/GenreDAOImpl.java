package library;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Genre genre) {
        entityManager.persist(genre);
    }

    @Override
    public Genre findOne(long id) {
        return entityManager.getReference(Genre.class, id);
    }

    @Override
    public List<Genre> list() {
        Query query = entityManager.createQuery("SELECT g FROM Genre g", Genre.class);
        return (List<Genre>) query.getResultList();
    }
}
