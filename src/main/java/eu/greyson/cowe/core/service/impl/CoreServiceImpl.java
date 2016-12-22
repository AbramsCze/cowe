package eu.greyson.cowe.core.service.impl;

import eu.greyson.cowe.core.model.User;
import eu.greyson.cowe.core.repository.UserRepository;
import eu.greyson.cowe.core.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Used as a facade for controllers. <br />
 * Also a placeholder for @Transactional and @Cacheable annotations
 */
@Service
public class CoreServiceImpl implements CoreService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findUserByLoginName(final String loginName) throws DataAccessException
    {
        return userRepository.findByLoginName(loginName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserById(Long id) throws DataAccessException
    {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(final User user)
    {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers()
    {
        return userRepository.findAll().collect(Collectors.toList());
    }
}
