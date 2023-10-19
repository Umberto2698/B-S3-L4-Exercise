package entities.events;

import entities.Evento;

import javax.persistence.*;

@Entity
public class PartitaDiCalcio extends Evento {
    @Column(name = "home_team")
    private String homeTeam;
    @Column(name = "foreign_team")
    private String foreignTeam;

    @Column(name = "winning_team")
    private String winningTeam;
    @Column(name = "home_team_goals")
    private int homeTeamGoals;
    @Column(name = "foreign_team_goals")
    private int foreignTeamGoals;
}
