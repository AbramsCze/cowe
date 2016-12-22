package eu.greyson.cowe.core.repository;

import eu.greyson.cowe.core.model.User;
import org.springframework.dao.DataAccessException;

/** Repository class for <code>User</code> domain objects. */
public interface UserRepository extends BaseRepository<User, Long>
{
    /**
     * Retrieve <code>User</code>s from the data store by login name.
     * @param loginName to search for.
     * @return a <code>User</code> or null.
     */
    User findByLoginName(String loginName) throws DataAccessException;
}
