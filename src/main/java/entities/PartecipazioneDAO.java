package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(partecipazione);

        transaction.commit();
        System.err.println("Partecipazione salvata:");
        System.out.println(partecipazione);
    }

    public Partecipazione findById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void findByIdAndDelete(long id) {
        Partecipazione found =findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La partecipazione è stata cancellata correttamente");
        } else {
            System.err.println("La partecipazione con l'id " + id + " non è stato trovato");
        }}
}
