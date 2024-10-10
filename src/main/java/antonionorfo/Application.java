package antonionorfo;

import antonionorfo.Dao.EventoDao;
import antonionorfo.Dao.LocationDao;
import antonionorfo.Dao.PartecipazioneDao;
import antonionorfo.Dao.PersonaDao;
import antonionorfo.Entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi-aggiornamento");
        EntityManager em = emf.createEntityManager();

        PersonaDao personaDao = new PersonaDao(em);
        LocationDao locationDao = new LocationDao(em);
        EventoDao eventoDao = new EventoDao(em);
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao(em);

        Persona persona1 = new Persona("Antonio", "Norfo", "anto@anto.mail", LocalDate.of(1992, 10, 17), Sesso.MASCHIO);
        Persona persona2 = new Persona("Pie", "Rom", "anto@anto.mail", LocalDate.of(1992, 10, 17), Sesso.MASCHIO);

        personaDao.save(persona1);
        personaDao.save(persona2);

        Location location1 = new Location("Slitta con i lupi", "Norvegia");
        Location location2 = new Location("Girare in barca", "Mondello");
        locationDao.save(location1);
        locationDao.save(location2);

        Evento evento1 = new Evento(LocalDate.of(2021, 10, 17), "Se avete sonno, non venite", TipoEvento.PUBBLICO, 100, location1, new ArrayList<>(), "Gran Teatro per il Natale"
        );
        Evento evento2 = new Evento(LocalDate.of(2023, 12, 05), "Non venite", TipoEvento.PUBBLICO, 60, location2, new ArrayList<>(), "Natale"
        );
        eventoDao.save(evento1);
        eventoDao.save(evento2);

        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Stato.CONFERMATO);
        Partecipazione partecipazione2 = new Partecipazione(persona2, evento2, Stato.NON_CONFERMATO);
        partecipazioneDao.save(partecipazione1);
        partecipazioneDao.save(partecipazione2);


        em.close();
        emf.close();


    }
}
