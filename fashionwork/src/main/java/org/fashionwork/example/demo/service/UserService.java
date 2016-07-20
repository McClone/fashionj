package org.fashionwork.example.demo.service;

import org.fashionwork.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zhengsd
 */
public interface UserService {

    User saveUser(User user);

    User deleteUser(User user);

    User findUser(String id);

}
