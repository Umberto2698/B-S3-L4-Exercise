package entities.events;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartitaDiCalcioDAO {
    private final EntityManager em;

    public PartitaDiCalcioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PartitaDiCalcio competition){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(competition);

        transaction.commit();
        System.err.println("Partita di calcio salvata:");
        System.out.println(competition);
    }

    public PartitaDiCalcio findById(long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public void findByIdAndDelete(long id) {
        PartitaDiCalcio found =findById(id);

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
