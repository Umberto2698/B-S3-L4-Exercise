package entities;

import enums.Stato;

import javax.persistence.*;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Persona person;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento event;
    @Enumerated(EnumType.STRING)
    private Stato state;

    public Partecipazione(){}

    public Partecipazione(Persona person, Evento event, Stato state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", state=" + state +
                '}';
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return person;
    }

    public void setPersona(Persona person) {
        this.person = person;
    }

    public Evento getEvento() {
        return event;
    }

    public void setEvento(Evento event) {
        this.event = event;
    }

    public Stato getState() {
        return state;
    }

    public void setState(Stato state) {
        this.state = state;
    }
}
