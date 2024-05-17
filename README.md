1)Creare un'entità "Prodotto" con i seguenti campi:
	ID (Integer)
	Nome (String)
	Descrizione (String)
	Prezzo (Double)
	Quantità disponibile (Integer)
	Categoria (relazione many-to-one con l'entità "Categoria")

2)Creare un'entità "Categoria" con i seguenti campi:
	ID (Integer)
	Nome (String)
	Descrizione (String)
	
- Implementare le operazioni CRUD per la gestione dei prodotti e delle categorie tramite API RESTful esposte tramite Swagger.
- Utilizzare Hibernate per mappare le entità "Prodotto" e "Categoria" al database e gestire la relazione one-to-many tra prodotti e categorie.
- Utilizzare Spring Boot per creare e configurare l'applicazione.
- Utilizzare Liquibase per definire e applicare i cambiamenti al database.

Suggerimenti
- Utilizzare Maven per la gestione delle dipendenze e la build del progetto.
- Definire una struttura di progetto modulare, separando la logica di business, i controllori REST, i servizi e la configurazione.
- Scrivere test unitari e/o di integrazione per garantire il corretto funzionamento del sistema.
- Documentare le API RESTful utilizzando Swagger.

Consegnabile
Il progetto dovrebbe essere consegnato come repository Git privato su una piattaforma come GitHub o GitLab
