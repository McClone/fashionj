package org.fashionwork.demo.web;

import org.fashionwork.shiro.web.AbstractLoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zhengsd
 */
@Controller
public class LoginController {

    @GetMapping("test")
    public String test(HttpSession httpSession) {
        httpSession.setAttribute("test", "test");
        return "redirect:http://localhost:8899/test";
    }

}
