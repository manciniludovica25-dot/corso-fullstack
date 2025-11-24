import { Ingrediente } from "./ingrediente.model";
export interface Piatto {
    id : number
    nome : string
    immagine : string
    prezzo : number
    categoria : string
    ingredienti : Ingrediente[]
}
