package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloStaticController {

    @GetMapping("hello-static")
    public String hello(Model model) {
        model.addAttribute("id", "20230511");
        model.addAttribute("name", "Anakin");
//        model.addAttribute("tel", "010-7400");

        return "hello";
    }
}
