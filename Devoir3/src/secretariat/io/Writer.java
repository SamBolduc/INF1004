package secretariat.io;

import java.io.File;

/**
 * Interface d'écriture
 *
 * @param <T>
 */
public interface Writer<T> {

    void write(T obj, File file);

}
