package entities.athlete;

import entities.Persona;
import entities.events.GaraDiAtletica;
import enums.AthleticsType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Atleta extends Persona {
    @Enumerated(value = EnumType.STRING)
    private AthleticsType athleticsType;

    @ManyToMany
    @JoinTable(name = "athlete_competition", joinColumns = @JoinColumn(name = "athlete_id"),inverseJoinColumns = @JoinColumn(name = "competition_id"))
    private Set<GaraDiAtletica> gareDiAtletica;

    @OneToMany(mappedBy = "vincitore")
    private Set<GaraDiAtletica> getGareDiAtleticaVinte;
}
