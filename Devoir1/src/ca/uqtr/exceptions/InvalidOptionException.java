/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Exception lancée lorsqu'une option invalide est choisis.
 */

package ca.uqtr.exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException() {
        super("L'option sélectionnée n'est pas valide. Veuillez en choisir une autre.");
    }
}
