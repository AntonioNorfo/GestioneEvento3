package antonionorfo.Dao;

import antonionorfo.Entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDao {

    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();

    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    public void deleteById(long id) {
        em.getTransaction().begin();
        Evento evento = findById(id);
        if (evento != null) {
            em.remove(evento);
        }
        em.getTransaction().commit();
    }
}
