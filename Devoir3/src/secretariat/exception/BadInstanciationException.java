/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.exception;

public class BadInstanciationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BadInstanciationException(String message) {
        super(message);
    }
}
