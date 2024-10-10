package antonionorfo.Dao;

import antonionorfo.Entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDao {
    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();

    }

    public Persona findById(UUID id) {
        return em.find(Persona.class, id);
    }

    public void deleteById(UUID id) {
        Persona persona = findById(id);
        if (persona != null) {
            em.remove(persona);
        }
    }
}

