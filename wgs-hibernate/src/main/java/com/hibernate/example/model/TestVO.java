package com.hibernate.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TestHibernate.
 */
@Entity
@Table(name="test")
public class TestVO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7320429264544385385L;

	/** The id. */
	@Id
	/** The id. */
	private int id;
	
	/** The name. */
	@Column(nullable = false)
	/** The name. */
	private String name;

	/* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TestVO other = (TestVO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

	/**
	 * Method gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
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
	 * Method sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
