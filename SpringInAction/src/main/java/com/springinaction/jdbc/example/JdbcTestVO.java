package com.springinaction.jdbc.example;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * The Class Test.
 */
public class JdbcTestVO {

	/** The id. */
	private int id;
	
	/** The name. */
	private String name;

	/**
	 * Method gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
