/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.exceptions;

@SuppressWarnings("serial")
public class InvalidOptionException extends Exception { //On ne veut pas généré un field pour le # de serialisation puisqu'il ne sera pas utilisé.
    public InvalidOptionException() {
        super("L'option sélectionnée n'est pas valide. Veuillez en choisir une autre.");
    }
}
