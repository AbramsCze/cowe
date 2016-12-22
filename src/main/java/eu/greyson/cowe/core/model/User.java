package eu.greyson.cowe.core.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

/** Domain object representing an user. */
@Entity
@Table(name = "get_user")
@DynamicInsert
@DynamicUpdate
@AttributeOverride(name = "id", column = @Column(name = "ID_USER"))
public class User extends Person
{
    @Column(name = "LOGIN_NAME")
    private String loginName;

    @Column(name = "PASSWORD")
    private String password;

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
