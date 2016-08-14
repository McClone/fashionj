package org.fashionwork.springboot.shiro.core.user;

import org.apache.shiro.authc.AccountException;


/**
 * Created by zheng on 2016/8/14.
 */
public interface UserDetailsService<T extends UserDetails> {

    T loadUser(String username, String password) throws AccountException;
}
