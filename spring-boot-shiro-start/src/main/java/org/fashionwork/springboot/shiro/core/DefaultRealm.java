package org.fashionwork.springboot.shiro.core;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.fashionwork.springboot.shiro.core.user.UserDetails;
import org.fashionwork.springboot.shiro.core.user.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * <p>Created Time 2016/8/14</p>
 *
 * @author zheng
 */
public class DefaultRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(DefaultRealm.class);

    private UserDetailsService userDetailsService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDetails userDetails = (UserDetails) principals.getPrimaryPrincipal();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = Arrays.toString(token.getPassword());
        UserDetails userDetails = userDetailsService.loadUser(username, password);
        if (userDetails == null) {
            throw new RuntimeException("load userDetails error");
        }
        return new SimpleAuthenticationInfo(userDetails, password, getName());
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
