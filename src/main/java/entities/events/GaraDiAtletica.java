package entities.events;

import entities.Evento;
import entities.Location;
import entities.athlete.Atleta;
import enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {
    @ManyToMany
    @JoinTable(name = "athlete_competition", joinColumns = @JoinColumn(name = "competition_id"),inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private Set<Atleta> atleti;

    @ManyToOne
    @JoinColumn(name = "winner")
    private Atleta vincitore;
    public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Set<Atleta> atleti, Atleta vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }


}
