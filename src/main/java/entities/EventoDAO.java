package entities;

import entities.events.Concerto;
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
//        SELECT c FROM Concerto c INNER JOIN Evento e ON c.id = e.id WHERE c.inSteaming = true
        TypedQuery<Concerto> getConcerti;
        if(b){
            getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = true", Concerto.class);
        }else{
            getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = false", Concerto.class);
        }
        return  getConcerti.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere){
        List<Concerto> concerti=new ArrayList<>();
        switch (genere){
            case POP -> {
                TypedQuery<Concerto> getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.genere LIKE POP", Concerto.class);
                concerti= getConcerti.getResultList();
            }
            case ROCK -> {
                TypedQuery<Concerto> getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.genere LIKE ROCK", Concerto.class);
                concerti= getConcerti.getResultList();

            }
            case CLASSICO -> {
                TypedQuery<Concerto> getConcerti = em.createQuery("SELECT c FROM Concerto c WHERE c.genere LIKE CLASSICO", Concerto.class);
                concerti= getConcerti.getResultList();

            }
        }
        return concerti;
    }
}
