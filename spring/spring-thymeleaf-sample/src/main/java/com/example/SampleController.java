package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {
    @GetMapping("/display-sample")
    public String displaySample(Model model) {
        model.addAttribute("fullName", "横浜太郎");
        return "sample";
    }
}
