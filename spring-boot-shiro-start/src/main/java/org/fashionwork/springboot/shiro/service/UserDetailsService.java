package org.fashionwork.springboot.shiro.service;

import org.fashionwork.springboot.shiro.core.UserDetails;

/**
 * Created by zheng on 2016/8/14.
 */
public interface UserDetailsService {

    UserDetails loadUserByUsername(String username);
}
