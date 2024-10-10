package antonionorfo.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_location", updatable = false, nullable = false)
    private UUID id_location;

    @Column(name = "nome_location", nullable = false)
    private String nome;

    @Column(name = "citta_location", nullable = false)
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getId_location() {
        return id_location;
    }

    public void setId_location(UUID id_location) {
        this.id_location = id_location;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id_location=" + id_location +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
