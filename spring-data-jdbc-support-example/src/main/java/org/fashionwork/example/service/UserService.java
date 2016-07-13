package org.fashionwork.example.service;

import org.fashionwork.example.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author zhengsd
 */
public interface UserService {

    Page<User> findAll(Pageable pageable);

}
