package marcozagaria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marcozagaria.entities.Utente;
import marcozagaria.exception.NotFoundException;

public class UtenteDAO {
    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();
        System.out.println("L'utente " + utente.getNome() + " è stato salvato correttamente");
    }

    public Utente findBynumeroTessera(int numeroTessera) {
        Utente found = entityManager.find(Utente.class, numeroTessera);
        if (found == null) throw new NotFoundException(numeroTessera);
        return found;
    }
}
