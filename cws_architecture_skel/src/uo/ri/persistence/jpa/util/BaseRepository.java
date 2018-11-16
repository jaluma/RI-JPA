package uo.ri.persistence.jpa.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseRepository<T> {

	/**
	 * Añade un objeto a estado persistant
	 * @param t a añadir
	 */
	public void add(T t) {
		Jpa.getManager().persist(t);
	}

	/**
	 * Saca a un objeto de persistant
	 * @param t a borrar
	 */
	public void remove(T t) {
		Jpa.getManager().remove(t);
	}

	/**
	 * Metodo que busca un objeto a partir de su id
	 * @param id a buscar
	 * @return object encontrado o null si no existe
	 */
	public T findById(Long id) {
		return Jpa.getManager().find(type, id);
	}

	/**
	 * Devuelve una lista con todos los objetos
	 * @return una lista (podria estar vacia) con los valores
	 */
	public List<T> findAll() {
		String entity = type.getName();
		String query = "select o from " + entity + " o";

		return Jpa.getManager().createQuery(query, type).getResultList();
	}

	/**
	 * As find() and the query "select x from X x" needs the type of the entity here
	 * there is a reflective way of getting it
	 */
	private Class<T> type;

	public BaseRepository() {
		this.type = hackTheTypeOfGenericParameter();
	}

	/**
	 * This is a hack to recover the runtime reflective type of <T>
	 */
	@SuppressWarnings("unchecked")
	private Class<T> hackTheTypeOfGenericParameter() {
		ParameterizedType superType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) superType.getActualTypeArguments()[0];
	}

}
