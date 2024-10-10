package antonionorfo.Dao;

import antonionorfo.Entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDao {

    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    public Location findById(UUID id) {
        return em.find(Location.class, id);
    }

    public void deleteById(UUID id) {
        em.getTransaction().begin();
        Location location = findById(id);
        if (location != null) {
            em.remove(location);
        }
        em.getTransaction().commit();
    }
}
