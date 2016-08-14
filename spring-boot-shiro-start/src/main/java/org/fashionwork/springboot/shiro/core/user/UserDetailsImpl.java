package org.fashionwork.springboot.shiro.core.user;

import java.io.Serializable;

/**
 * <p>Created Time 2016/8/14</p>
 *
 * @author zheng
 */
public class UserDetailsImpl implements UserDetails, Serializable {

    private static final long serialVersionUID = 5235115693307487207L;
    private String userId;
    private String account;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
