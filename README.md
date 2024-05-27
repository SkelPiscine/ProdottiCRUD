Requisiti
Parte 1: Prodotto e Categoria (MICROSERVIZIO)

Entità "Prodotto"
ID (Integer)
Nome (String)
Descrizione (String)
Prezzo (Double)
Quantità disponibile (Integer)
Categoria (relazione many-to-one con l'entità "Categoria")

Entità "Categoria"
ID (Integer)
Nome (String)
Descrizione (String)
Prodotti (relazione one-to-many)

Parte 2: Operazioni CRUD
Implementare le operazioni CRUD per la gestione dei prodotti e delle categorie tramite API RESTful.
Documentare le API RESTful utilizzando Swagger.

Parte 3: Persistenza e Configurazione
Utilizzare Hibernate per mappare le entità "Prodotto" e "Categoria" al database.
Utilizzare Spring Boot per creare e configurare l'applicazione.
Utilizzare Liquibase per definire e applicare i cambiamenti al database.

Parte 4: Gestione delle Dipendenze e Build del Progetto
Utilizzare Maven per la gestione delle dipendenze e la build del progetto.

Parte 5: Struttura del Progetto
Definire una struttura di progetto modulare, separando la logica di business, i controllori REST, i servizi e la configurazione.

Parte 6: Testing
Scrivere test unitari e/o di integrazione per garantire il corretto funzionamento del sistema.

Parte 7: User Microservice e Relazioni Ordini  (Microservizio)
Entità "Utente"
ID (Integer)
Nome (String)
Email (String)
Password (String)

Entità "Ordine"
ID (Integer)
Data (Date)
Utente (relazione many-to-one con l'entità "Utente")
Prodotti (relazione many-to-many con l'entità "Prodotto")

Relazioni
Un utente può avere molti ordini (1:N).
Un ordine può contenere molti prodotti e un prodotto può essere contenuto in molti ordini (N:N).
Una categoria può avere molti prodotti (1:N).


Organizzare il progetto seguendo una struttura modulare (es. controller, service, repository, entity, config).
Configurazione di Hibernate e Liquibase

Definire le entità JPA per Hibernate.
Utilizzare Liquibase per il versionamento del database e per applicare gli aggiornamenti dello schema.

Documentazione API
Utilizzare Swagger per documentare le API RESTful.
Configurare Swagger per generare automaticamente la documentazione delle API.

Test
Scrivere test unitari per i servizi e le entità.
Scrivere test di integrazione per i controller REST.

