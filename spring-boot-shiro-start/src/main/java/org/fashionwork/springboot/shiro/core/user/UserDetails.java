package org.fashionwork.springboot.shiro.core.user;

import java.io.Serializable;

/**
 * <p>Created Time 2016/8/14</p>
 *
 * @author zheng
 */
public interface UserDetails {

    String getUserId();

    String getAccount();

}
