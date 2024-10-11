package marcozagaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marcozagaria.dao.ElementiDelCatalogoDAO;
import marcozagaria.dao.PrestitoDAO;
import marcozagaria.dao.UtenteDAO;
import marcozagaria.entities.*;
import marcozagaria.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w3_progetto");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ElementiDelCatalogoDAO elementoDAO = new ElementiDelCatalogoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);


        try {
//---------------------------------------metodi dei libri---------------------------------------------
            Libro libro1 = new Libro("Harry Potter", LocalDate.of(1996, 10, 5), 564, "J.K. Rowling", "fantasy");
            Libro libro2 = new Libro("Harry Potter 2", LocalDate.of(1998, 10, 5), 564, "J.K. Rowling", "fantasy");
            Libro libro3 = new Libro("Il Signore Degli Anelli", LocalDate.of(1996, 10, 5), 564, "J.R.R. Tolkien", "fantasy");
            Rivista rivista1 = new Rivista("National Geographic", LocalDate.of(2000, 1, 1), 50, Periodicità.MENSILE);
//        elementoDAO.save(libro1);
//        elementoDAO.save(libro2);
//        elementoDAO.save(libro3);
//        elementoDAO.save(rivista1);
            List<ElementoDelCatalogo> cercaPerTitolo = elementoDAO.findByTitolo("Harry Potter");
            cercaPerTitolo.forEach(System.out::println);
//        elementoDAO.findElementoDelCatalogoByCodiceISBNAndDelete(52);
            List<ElementoDelCatalogo> cercaPerAnno = elementoDAO.findByYear(LocalDate.of(1996, 10, 5));
            cercaPerAnno.forEach(System.out::println);
            List<Libro> cercaAutore = elementoDAO.findByAutore("J.R.R. Tolkien");
            cercaAutore.forEach(System.out::println);
            ElementoDelCatalogo cercaISBN = elementoDAO.findByCodiceISBN(1);
            System.out.println(cercaISBN);

//--------------------------------------metodi dell'utente--------------------------------------------

            Utente utente1 = new Utente("aldo", "baglio", LocalDate.of(1973, 10, 15));
            Utente utente2 = new Utente("giovanni", "storti", LocalDate.of(1983, 2, 4));
            Utente utente3 = new Utente("giacomo", "poretti", LocalDate.of(1963, 7, 20));
//        utenteDAO.save(utente1);
//            utenteDAO.save(utente2);
//            utenteDAO.save(utente3);
            Utente cercaUtente = utenteDAO.findBynumeroTessera(1);
            System.out.println(cercaUtente);

            //--------------------------------------metodi del prestito--------------------------------------------
            Prestito prestito1 = new Prestito(cercaUtente, cercaISBN, LocalDate.of(2024, 9, 18), LocalDate.of(2024, 9, 18).plusDays(30), LocalDate.of(2024, 10, 10));

//            prestitoDAO.save(prestito1);



        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
