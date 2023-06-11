package hello.hellospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogController {

    private final Logger logger = LoggerFactory.getLogger("LoggerController 의 로그");

    @GetMapping("/log")
    public String log (Model model) {
        model.addAttribute("data", "로깅 발생!!");

        logger.info("로깅 발생!");
        return "hello";
    }
}