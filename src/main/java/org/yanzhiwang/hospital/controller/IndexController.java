package org.yanzhiwang.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String displayIndexPage() {
        return "indexPage";
    } 

    @GetMapping("/about")
    public String displayAboutPage() {
        return "aboutPage";
    } 

    @GetMapping("/contact")
    public String displayContactPage() {
        return "contactPage";
    }
}
