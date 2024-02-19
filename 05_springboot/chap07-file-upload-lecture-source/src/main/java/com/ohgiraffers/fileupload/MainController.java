package com.ohgiraffers.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//    @RequestMapping(value = {"/", "/main"})
//    public String main() {
//        return "main";
//    }

    @GetMapping("/")
    public String defaultLocation() {
        return "main";
    }

    @GetMapping("main")
    public void main() {
    }
}
