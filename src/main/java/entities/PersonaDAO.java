package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(persona);

        transaction.commit();
        System.err.println("Persona salvato:");
        System.out.println(persona);
    }

    public Persona findById(long id) {
        return em.find(Persona.class, id);
    }

    public void findByIdAndDelete(long id) {
        Persona found =findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La persona è stata cancellata correttamente");
        } else {
            System.err.println("La persona con l'id " + id + " non è stato trovato");
        }}
}
