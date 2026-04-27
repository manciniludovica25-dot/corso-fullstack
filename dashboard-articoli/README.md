# Dashboard Admin (Articoli, Commenti, Utenti, Ruoli) — Vanilla JS + JSON Server

Questa è una **dashboard amministrativa** sviluppata in **HTML/CSS/JavaScript (senza framework)** che permette di gestire:

- **Articoli** (posts)
- **Commenti** (comments)
- **Utenti** (users)
- **Ruoli** (roles)

I dati arrivano da un backend mock realizzato con **json-server** (file `db.json`).

---

## Funzionalità principali

### Sezioni gestite
Nel menu laterale puoi passare tra:
- Articoli
- Commenti
- Utenti
- Ruoli
- **Cestino** (per ogni sezione)

### CRUD + cestino (soft delete)
Ogni entità supporta:
- **Creazione** (Nuovo)
- **Modifica**
- **Eliminazione logica** → sposta nel **cestino** impostando `isActive: false`
- **Ripristino** dal cestino → `isActive: true`
- **Eliminazione definitiva** (solo dal cestino)

### Ricerca e filtri
- Ricerca testuale (minimo 3 caratteri)
- Filtri per sezione (es. autore per articoli, articolo per commenti, ruolo per utenti)
- Evidenziazione del testo trovato (tag `<mark>`)

### Paginazione
- Precedente / Successiva
- Selezione pagina
- Scelta elementi per pagina (5/10/15/20)

### Modali
- Modale generica per inserimento/modifica (campi dinamici in base alla sezione)
- Validazioni:
  - campi obbligatori
  - email valida per i commenti/utenti

### Visualizzazione articolo completo + commenti
Nella sezione **Articoli** è disponibile il pulsante **👁️ Vedi** che apre una modale **in sola lettura** con:
- titolo e corpo completo dell’articolo
- lista dei **commenti associati** (filtrati per `postId`)

### Caricamento e notifiche
- Stato di caricamento con spinner
- Notifiche “volanti” (successo/errore/caricamento)
- Blocco temporaneo UI durante le operazioni (per evitare click multipli)

### Simulazione errori
È presente una simulazione casuale degli errori server (circa 1 volta su 10) per testare la gestione degli errori e i retry.

---

## Struttura dati (db.json)

Il progetto assume entità con queste proprietà (minime):

### Articoli (`posts`)
- `id` (number)
- `titolo` (string)
- `corpo` (string)
- `utenteId` (number)
- `creatoIl` (string `YYYY-MM-DD`)
- `isActive` (boolean)

### Commenti (`comments`)
- `id`
- `postId` (number)
- `nome` (string)
- `email` (string)
- `corpo` (string)
- `isActive` (boolean)

### Utenti (`users`)
- `id`
- `nome` (string)
- `username` (string)
- `email` (string)
- `ruoloId` (number)
- `isActive` (boolean)

### Ruoli (`roles`)
- `id`
- `nome` (string)
- `descrizione` (string)
- `isActive` (boolean)

---

## Avvio in locale (Windows)

### 1) Installazione
Apri PowerShell/CMD nella cartella del progetto (dove ci sono `package.json` e `db.json`) e lancia:

```bash
npm install
```

### 2) Avvio backend (json-server)
Su Windows usa la porta fissa 3000:

```bash
npm run server
```

Verifica nel browser:
- http://localhost:3000/posts
- http://localhost:3000/comments
- http://localhost:3000/users
- http://localhost:3000/roles

### 3) Avvio frontend
Apri `index.html` nel browser.

Consigliato: usa VS Code + estensione **Live Server** per evitare problemi di cache.

---

## Configurazione API
Nel frontend è presente:

```js
const API_BASE = "http://localhost:3000";

## Autrice
- Repo/utente: `manciniludovica25-dot`