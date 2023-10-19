import entities.EventoDAO;
import entities.Location;
import entities.LocationDAO;
import entities.events.Concerto;
import entities.events.PartitaDiCalcio;
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


//        Location l1=new Location("San Siro", "Milano");
//      ld.save(l1);
//     PartitaDiCalcio c1=new PartitaDiCalcio("Coppa Italia", LocalDate.now(),"Milan - Juve", TipoEvento.PUBBLICO,300000,l1, "Milan",  "Juve", "Milan", 2,1);
//    ev.save(c1);
//        PartitaDiCalcio c2=new PartitaDiCalcio("Coppa Italia", LocalDate.now(),"Juve - Milan", TipoEvento.PUBBLICO,300000,l1, "Juve",  "Milan", "Milan", 3,5);
//        ev.save(c2);


//        ev.getConcertiInStreaming(true).forEach(System.out::println);
//        ev.getConcertiPerGenere(Genere.ROCK).forEach(System.out::println);

        ev.getPartiteVinteInCasa("Milan").forEach(System.out::println);
        ev.getPartiteVinteInTrasferta("Juve").forEach(System.out::println);


        emf.close();
        em.close();
    }
}
