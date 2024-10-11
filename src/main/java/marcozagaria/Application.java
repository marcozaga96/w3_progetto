package marcozagaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marcozagaria.dao.ElementiDelCatalogoDAO;
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
//---------------------------------------metodi dei libri---------------------------------------------
        try {
            Libro libro1 = new Libro("Harry Potter", LocalDate.of(1996, 10, 5), 564, "J.K. Rowling", "fantasy");
//        elementoDAO.save(libro1);
            Libro libro2 = new Libro("Harry Potter 2", LocalDate.of(1998, 10, 5), 564, "J.K. Rowling", "fantasy");
//        elementoDAO.save(libro2);
            Libro libro3 = new Libro("Il Signore Degli Anelli", LocalDate.of(1996, 10, 5), 564, "J.R.R. Tolkien", "fantasy");
//        elementoDAO.save(libro3);
            Rivista rivista1 = new Rivista("National Geographic", LocalDate.of(2000, 1, 1), 50, Periodicità.MENSILE);
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
//        utenteDAO.save(utente1);
            Utente cercaUtente = utenteDAO.findBynumeroTessera(1);
            System.out.println(cercaUtente);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
