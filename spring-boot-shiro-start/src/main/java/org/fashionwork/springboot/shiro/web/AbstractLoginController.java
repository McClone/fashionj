package org.fashionwork.springboot.shiro.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhengsd
 */
public abstract class AbstractLoginController {

    private static final Logger logger = LoggerFactory.getLogger(AbstractLoginController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<String> login(String username, String password, boolean rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("login true", HttpStatus.OK);
    }
}
