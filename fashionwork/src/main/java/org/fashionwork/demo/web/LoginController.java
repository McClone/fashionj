package org.fashionwork.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
