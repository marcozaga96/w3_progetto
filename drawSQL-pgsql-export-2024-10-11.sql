CREATE TABLE "elemento del catalogo"(
    "id" INTEGER NOT NULL,
    "titolo" VARCHAR(255) NOT NULL,
    "anno pubblicazione" DATE NOT NULL,
    "numero pagine" BIGINT NOT NULL
);
ALTER TABLE
    "elemento del catalogo" ADD PRIMARY KEY("id");
CREATE TABLE "rivista"(
    "id" INTEGER NOT NULL,
    "periodicità" BIGINT NOT NULL
);
ALTER TABLE
    "rivista" ADD PRIMARY KEY("id");
CREATE TABLE "libro"(
    "id" INTEGER NOT NULL,
    "autore" VARCHAR(255) NOT NULL,
    "genere" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "libro" ADD PRIMARY KEY("id");
CREATE TABLE "prestito"(
    "id" INTEGER NOT NULL,
    "utente" INTEGER NOT NULL,
    "elemento prestato" INTEGER NOT NULL,
    "data inizio prestito" DATE NOT NULL,
    "data restituzione prevista" DATE NOT NULL,
    "data restituzione effettiva" BIGINT NOT NULL
);
ALTER TABLE
    "prestito" ADD PRIMARY KEY("id");
CREATE TABLE "utente"(
    "numero di tessera" INTEGER NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "cognome" VARCHAR(255) NOT NULL,
    "data di nascita" DATE NOT NULL
);
ALTER TABLE
    "utente" ADD PRIMARY KEY("numero di tessera");
ALTER TABLE
    "utente" ADD CONSTRAINT "utente_numero di tessera_foreign" FOREIGN KEY("numero di tessera") REFERENCES "prestito"("id");
ALTER TABLE
    "rivista" ADD CONSTRAINT "rivista_id_foreign" FOREIGN KEY("id") REFERENCES "elemento del catalogo"("id");
ALTER TABLE
    "prestito" ADD CONSTRAINT "prestito_id_foreign" FOREIGN KEY("id") REFERENCES "rivista"("id");
ALTER TABLE
    "prestito" ADD CONSTRAINT "prestito_id_foreign" FOREIGN KEY("id") REFERENCES "libro"("id");
ALTER TABLE
    "libro" ADD CONSTRAINT "libro_id_foreign" FOREIGN KEY("id") REFERENCES "elemento del catalogo"("id");