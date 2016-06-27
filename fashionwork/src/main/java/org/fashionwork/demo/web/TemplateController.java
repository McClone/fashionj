package org.fashionwork.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * @author zhengsd
 */
@Controller
public class TemplateController {

    @RequestMapping("/doit")
    public String doIt(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "/doit";
    }

}
