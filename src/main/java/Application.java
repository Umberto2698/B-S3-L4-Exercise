import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static utils.JpaUtils.getEntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf=getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();

        emf.close();
        em.close();
    }
}
