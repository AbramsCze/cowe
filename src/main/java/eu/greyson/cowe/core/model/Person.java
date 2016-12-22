package eu.greyson.cowe.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/** Domain object representing an person. */
@MappedSuperclass
public abstract class Person extends BaseEntity
{
    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName()
    {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString() {
        return this.getFullName();
    }
}
