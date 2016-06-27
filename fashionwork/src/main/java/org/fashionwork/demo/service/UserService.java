package org.fashionwork.demo.service;

import org.fashionwork.demo.domain.User;

/**
 * @author zhengsd
 */
public interface UserService {

    User saveUser(User user);

    User deleteUser(User user);

    Iterable<User> findAll();

    User findUser(String id);
}
