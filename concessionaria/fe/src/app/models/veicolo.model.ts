export interface Veicolo {
  id: number;
  modello: string;
  marca: string;
  codiceImmatricolazione: string;
  dataImmatricolazione: string; // ISO string (es. "2020-05-12")
  prezzo: number;
}
