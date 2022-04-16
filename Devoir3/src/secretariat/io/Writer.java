package secretariat.io;

import java.io.File;

/**
 * 
 * Interface d'écriture
 *
 * @param <T>
 */
public interface Writer<T> {

	public abstract void write(T obj, File file);

}
