package entities;

import entities.events.Concerto;
import entities.events.PartitaDiCalcio;
import enums.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(event);

        transaction.commit();
        System.err.println("Evento salvato:");
        System.out.println(event);
    }

    public Evento findById(long id) {
        return em.find(Evento.class, id);
    }

    public void findByIdAndDelete(long id) {
        Evento found =findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'evento è stato cancellato correttamente");
        } else {
            System.err.println("L'evento con l'id " + id + " non è stato trovato");
        }}

    public List<Concerto> getConcertiInStreaming(boolean b){
        TypedQuery<Concerto> getConcerti;
        if(b){
          getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :b", Concerto.class);
          getConcerti.setParameter("b",b);
        }else{
            getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = false", Concerto.class);
        }
        return  getConcerti.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere){
                TypedQuery<Concerto> getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.genere LIKE :genere", Concerto.class);
                getConcerti.setParameter("genere",genere);
        return getConcerti.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa(String homeTeam){
        TypedQuery<PartitaDiCalcio> getPartiteVinteInCasa =em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        if(getPartiteVinteInCasa.getResultList().isEmpty()){
            System.out.println("Nessuna partita vinta in casa");
        }
        return getPartiteVinteInCasa.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(String homeTeam){
        TypedQuery<PartitaDiCalcio> getPartiteVinteInTrasferta =em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        if(getPartiteVinteInTrasferta.getResultList().isEmpty()){
            System.out.println("Nessuna partita vinta in trasferta");
        }
        return getPartiteVinteInTrasferta.getResultList();
    }


}
