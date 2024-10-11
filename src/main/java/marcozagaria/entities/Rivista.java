package marcozagaria.entities;

import java.time.LocalDate;

public class Rivista extends ElementoDelCatalogo {
    private Periodicità periodicità;

    public Rivista(int codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }
}
