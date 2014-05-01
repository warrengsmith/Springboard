package com.hibernate.example.dao;

import java.io.Serializable;
import java.util.List;

/**
 * The Interface IOperations.
 *
 * @param <T> the generic type
 */
public interface IOperations<T extends Serializable> {

	/**
	 * Method Find one.
	 *
	 * @param id the id
	 * @return the t
	 */
	T findOne(final long id);

	/**
	 * Method Find all.
	 *
	 * @return the list
	 */
	List<T> findAll();

	/**
	 * Method Creates the entity.
	 *
	 * @param entity the entity
	 */
	void create(final T entity);

	/**
	 * Method Update.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	T update(final T entity);

	/**
	 * Method Delete.
	 *
	 * @param entity the entity
	 */
	void delete(final T entity);

	/**
	 * Method Delete by id.
	 *
	 * @param entityId the entity id
	 */
	void deleteById(final long entityId);
}
