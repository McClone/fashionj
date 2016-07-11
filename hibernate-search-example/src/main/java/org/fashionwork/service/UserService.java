package org.fashionwork.service;


import org.fashionwork.domain.User;

import java.util.List;

/**
 * @author zhengsd
 */
public interface UserService {

    List<User> findUserFullText(String keyWord) throws InterruptedException;
}
