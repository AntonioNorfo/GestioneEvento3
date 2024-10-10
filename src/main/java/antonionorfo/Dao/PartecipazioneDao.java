package antonionorfo.Dao;

import antonionorfo.Entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDao {

    private final EntityManager em;

    public PartecipazioneDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
    }

    public Partecipazione findById(UUID id) {
        return em.find(Partecipazione.class, id);
    }

    public void deleteById(UUID id) {
        em.getTransaction().begin();
        Partecipazione partecipazione = findById(id);
        if (partecipazione != null) {
            em.remove(partecipazione);
        }
        em.getTransaction().commit();
    }
}
