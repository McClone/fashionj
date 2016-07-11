package org.fashionwork.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author zhengsd
 */
@RestController
public class IndexController {

    @GetMapping("index")
    public String test(HttpSession httpSession) {
        httpSession.setAttribute("index", new Date());
        return "index";
    }

}
