package entities.athlete;

import entities.Persona;
import entities.events.GaraDiAtletica;
import enums.AthleticsType;
import enums.Sex;

import javax.persistence.*;
import java.time.LocalDate;
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


    public Atleta(){}
    public Atleta(String name, String surname, String email, LocalDate birthday, Sex sex, AthleticsType athleticsType) {
        super(name, surname, email, birthday, sex);
        this.athleticsType = athleticsType;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "athleticsType=" + athleticsType +
                '}';
    }

    public AthleticsType getAthleticsType() {
        return athleticsType;
    }

    public void setAthleticsType(AthleticsType athleticsType) {
        this.athleticsType = athleticsType;
    }

    public Set<GaraDiAtletica> getGareDiAtletica() {
        return gareDiAtletica;
    }

    public Set<GaraDiAtletica> getGetGareDiAtleticaVinte() {
        return getGareDiAtleticaVinte;
    }

}
