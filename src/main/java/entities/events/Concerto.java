package entities.events;

import entities.Evento;
import enums.Genere;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Concerto extends Evento {
    @Enumerated(value = EnumType.STRING)
    private Genere genere;

    @Column(name = "in_streaming")
    private boolean inStreaming;
}
