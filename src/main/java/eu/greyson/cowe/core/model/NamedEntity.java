package eu.greyson.cowe.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/** Superclass for entity with name. */
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity
{
    /** Record name. */
    @Column(name = "NAME")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
