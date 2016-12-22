package eu.greyson.cowe.core.model;

import javax.persistence.*;

/** Simple domain object which works with primary key. */
@MappedSuperclass
public abstract class BaseEntity
{
    /** Storage primary key. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** @return object currenty doesn't exist in storage. */
    public boolean isNew()
    {
        return id == null;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
