package marcozagaria.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "elementi_del_catalogo")
public abstract class ElementoDelCatalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codiceISBN;
    private String titolo;
    private LocalDate annoPubblicazione;
    private int numeroPagine;

    @OneToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti;

    public ElementoDelCatalogo(String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public ElementoDelCatalogo() {
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "ElementoDelCatalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", prestiti=" + prestiti +
                '}';
    }
}
