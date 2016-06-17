package org.mcclone.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.mcclone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhengsd
 */
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        userService.saveUser();
        logger.info("index");
        return "index";
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    @ResponseBody
    public String unauthorized() {
        logger.info("unauthorized");
        return "unauthorized";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login() {
        logger.info("login");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(String username, String password, boolean rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
            logger.info("用户【" + subject.getPrincipal() + "】：登录成功！");
            subject.getSession().setAttribute("username", username);
            return "/index";
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return "/login";
    }

}
