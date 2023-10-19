package entities.events;

import entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ConcertoDAO {
    private final EntityManager em;

    public ConcertoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Concerto concert){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(concert);

        transaction.commit();
        System.err.println("Concerto salvato:");
        System.out.println(concert);
    }

    public Concerto findById(long id) {
        return em.find(Concerto.class, id);
    }

    public void findByIdAndDelete(long id) {
        Concerto found =findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'evento è stato cancellato correttamente");
        } else {
            System.err.println("L'evento con l'id " + id + " non è stato trovato");
        }}
}
