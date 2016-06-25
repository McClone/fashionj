package org.fashion.work.service;

import org.fashion.work.domain.User;

/**
 * @author zhengsd
 */
public interface UserService {

    User saveUser(User user);

    User deleteUser(User user);

    Iterable<User> findAll();

    User findUser(String id);
}
