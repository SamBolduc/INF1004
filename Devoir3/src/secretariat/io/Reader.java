/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.io;

import java.io.File;

/**
 * Interface de lecture
 *
 * @param <T>
 */
public interface Reader<T> {

    T read(File file);

}
