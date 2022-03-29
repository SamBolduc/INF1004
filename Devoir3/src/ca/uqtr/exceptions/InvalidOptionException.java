/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Exception lancée lorsqu'une option invalide est choisis.
 */

package ca.uqtr.exceptions;

@SuppressWarnings("serial")
public class InvalidOptionException extends Exception { //On ne veut pas généré un field pour le # de serialisation puisqu'il ne sera pas utilisé.
    public InvalidOptionException() {
        super("L'option sélectionnée n'est pas valide. Veuillez en choisir une autre.");
    }
}
