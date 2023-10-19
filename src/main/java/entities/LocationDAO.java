package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(location);

        transaction.commit();
        System.err.println("Location salvato:");
        System.out.println(location);
    }

    public Location findById(long id) {
        return em.find(Location.class, id);
    }

    public void findByIdAndDelete(long id) {
        Location found =findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La location è stata cancellata correttamente");
        } else {
            System.err.println("La location con l'id " + id + " non è stato trovato");
        }}
}
