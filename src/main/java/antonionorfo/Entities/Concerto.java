package antonionorfo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;

    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }

}
