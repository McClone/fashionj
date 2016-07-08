package org.fashionwork.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhengsd
 */
@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("test")
    public String test(HttpSession httpSession) {
        logger.info(String.valueOf(httpSession.getAttribute("test")));
        return "test";
    }

}
