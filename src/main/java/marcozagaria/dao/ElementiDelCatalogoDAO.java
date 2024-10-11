package marcozagaria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import marcozagaria.entities.ElementoDelCatalogo;
import marcozagaria.entities.Libro;
import marcozagaria.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public class ElementiDelCatalogoDAO {
    private final EntityManager entityManager;

    public ElementiDelCatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ElementoDelCatalogo elementoDelCatalogo) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(elementoDelCatalogo);
        transaction.commit();
        System.out.println("L'elemento " + elementoDelCatalogo.getTitolo() + " è stato salvato correttamente");
    }

    public void findElementoDelCatalogoByCodiceISBNAndDelete(int codiceISBN) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM ElementoDelCatalogo e WHERE e.codiceISBN = :codiceISBN");
        query.setParameter("codiceISBN", codiceISBN);
        if (query != null) throw new NotFoundException("codiceISBN non trovato");
        int numCancellati = query.executeUpdate();
        transaction.commit();
        System.out.println(numCancellati + " elementi sono stati cancellati con successo");
    }

    public ElementoDelCatalogo findByCodiceISBN(int codiceISBN) {
        ElementoDelCatalogo found = entityManager.find(ElementoDelCatalogo.class, codiceISBN);
        if (found == null) throw new NotFoundException("codiceISBN non trovato");
        return found;
    }

    public List<ElementoDelCatalogo> findByYear(LocalDate anno) {
        TypedQuery<ElementoDelCatalogo> query = entityManager.createQuery("SELECT e FROM ElementoDelCatalogo e WHERE e.annoPubblicazione = :anno", ElementoDelCatalogo.class);
        query.setParameter("anno", anno);
        if (query == null) throw new NotFoundException("anno non trovato");
        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
        query.setParameter("autore", autore);
        if (query == null) throw new NotFoundException("autore non trovato");
        return query.getResultList();
    }

    public List<ElementoDelCatalogo> findByTitolo(String titolo) {
        TypedQuery<ElementoDelCatalogo> query = entityManager.createQuery(
                "SELECT e FROM ElementoDelCatalogo e WHERE e.titolo LIKE :titolo", ElementoDelCatalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        if (query == null) throw new NotFoundException("titolo non trovato");
        return query.getResultList();
    }
}
