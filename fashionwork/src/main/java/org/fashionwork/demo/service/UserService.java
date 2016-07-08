package org.fashionwork.demo.service;

import org.fashionwork.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zhengsd
 */
public interface UserService {

    User saveUser(User user);

    User deleteUser(User user);

    Iterable<User> findAll();

    User findUser(String id);

    Page<User> findAll(Pageable pageable);

    List<User> findUserFullText(String keyWord) throws InterruptedException;
}
