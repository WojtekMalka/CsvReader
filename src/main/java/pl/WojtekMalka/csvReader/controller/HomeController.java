package pl.WojtekMalka.csvReader.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private static final String PAGE_HOME = "home";

    @GetMapping("/")
    String showHome(Model model) {
        return PAGE_HOME;
    }
}
