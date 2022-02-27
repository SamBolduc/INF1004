/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Exception lancée si la persistence n'a pas été initialisé.
 */

package ca.uqtr.exceptions;

@SuppressWarnings("serial")
public class NoPersistentDataException extends Exception { //On ne veut pas généré un field pour le # de serialisation puisqu'il ne sera pas utilisé.

    public NoPersistentDataException() {
        super("Les données n'a pas été initialisés.");
    }

}
