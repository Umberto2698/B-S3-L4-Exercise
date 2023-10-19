package entities.events;

import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE LOWER(p.winningTeam) LIKE LOWER(homeTeam) AND LOWER(p.homeTeam) LIKE LOWER(homeTeam)")
@NamedQuery(name = "getPartiteVinteInTrasferta",query = "SELECT p FROM PartitaDiCalcio p WHERE LOWER(p.winningTeam) LIKE LOWER(homeTeam) AND LOWER(p.foreignTeam) LIKE LOWER(homeTeam)")
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


    public PartitaDiCalcio(){}
    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String homeTeam, String foreignTeam, String winningTeam, int homeTeamGoals, int foreignTeamGoals) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.homeTeam = homeTeam;
        this.foreignTeam = foreignTeam;
        this.winningTeam = winningTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.foreignTeamGoals = foreignTeamGoals;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "homeTeam='" + homeTeam + '\'' +
                ", foreignTeam='" + foreignTeam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", homeTeamGoals=" + homeTeamGoals +
                ", foreignTeamGoals=" + foreignTeamGoals +
                '}';
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getForeignTeam() {
        return foreignTeam;
    }

    public void setForeignTeam(String foreignTeam) {
        this.foreignTeam = foreignTeam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getForeignTeamGoals() {
        return foreignTeamGoals;
    }

    public void setForeignTeamGoals(int foreignTeamGoals) {
        this.foreignTeamGoals = foreignTeamGoals;
    }
}
