package org.fashionwork.example.service;


import org.fashionwork.example.domain.User;

import java.util.List;

/**
 * @author zhengsd
 */
public interface UserService {

    List<User> findUserFullText(String keyWord) throws InterruptedException;
}
