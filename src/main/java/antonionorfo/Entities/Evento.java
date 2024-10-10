package antonionorfo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Evento {
    @Column(name = "titolo_evento", nullable = false)
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione_evento")
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private long id;
    @Column(name = "numero_massimo_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "id_location", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "nome_evento")
    private List<Partecipazione> partecipazioni;

    public Evento() {
    }

    public Evento(LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Partecipazione> partecipazioni, String titolo) {
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
        this.partecipazioni = partecipazioni;
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public long getId() {
        return id;
    }


    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", id=" + id +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                '}';
    }

    public void setId_evento(UUID uuid) {
    }

    public void setNome(String concerto) {
    }
}
