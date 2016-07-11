package org.fashionwork.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * @author zhengsd
 */
@Controller
@RequestMapping("/thymeleaf")
public class TemplateController {

    @RequestMapping("/index")
    public String doIt(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "/index";
    }

}
