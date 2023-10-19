package entities.events;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GaraDiAtleticaDAO {
    private final EntityManager em;

    public GaraDiAtleticaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(GaraDiAtletica competition){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(competition);

        transaction.commit();
        System.err.println("Gara di atletica salvata:");
        System.out.println(competition);
    }

    public GaraDiAtletica findById(long id) {
        return em.find(GaraDiAtletica.class, id);
    }

    public void findByIdAndDelete(long id) {
        GaraDiAtletica found =findById(id);

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
