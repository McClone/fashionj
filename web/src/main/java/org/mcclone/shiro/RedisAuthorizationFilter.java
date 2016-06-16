package org.mcclone.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author zhengsd
 */
public class RedisAuthorizationFilter extends AdviceFilter {


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = SecurityUtils.getSubject();

        return super.preHandle(request, response);
    }
}
