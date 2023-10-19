import entities.EventoDAO;
import entities.Location;
import entities.LocationDAO;
import entities.events.Concerto;
import enums.Genere;
import enums.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.time.LocalDate;

import static utils.JpaUtils.getEntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf=getEntityManagerFactory();
        EntityManager em=emf.createEntityManager();

        EventoDAO ev=new EventoDAO(em);
        LocationDAO ld=new LocationDAO(em);


//        Location l1=new Location("Stadio Monaco", "Monaco");
//      ld.save(l1);
//        Concerto c1=new Concerto("Maneskin in Tour", LocalDate.now(),"Quarto incontro", TipoEvento.PUBBLICO,30000,l1, Genere.ROCK,false);
//     ev.save(c1);

        ev.getConcertiInStreaming(true).forEach(System.out::println);
        ev.getConcertiPerGenere(Genere.ROCK).forEach(System.out::println);


        emf.close();
        em.close();
    }
}
