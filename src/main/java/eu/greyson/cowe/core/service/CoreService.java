package eu.greyson.cowe.core.service;

import eu.greyson.cowe.core.model.User;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Optional;

/** Used as a facade so controllers have a single point of entry. */
public interface CoreService
{
    /**
     * @return user with loginName or null.
     * @throws DataAccessException
     */
    User findUserByLoginName(String loginName) throws DataAccessException;

    /**
     * @return user with id or null.
     * @throws DataAccessException
     */
    Optional<User> findUserById(Long id) throws DataAccessException;

    /**
     * Persist user to storage.
     */
    User saveUser(User user);

    /**
     * @return all users.
     */
    List<User> findAllUsers();
}
