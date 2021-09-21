package pl.WojtekMalka.csvReader.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.WojtekMalka.csvReader.repository.ClientRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private static final String PAGE_CLIENT_VIEW = "client/view";

    private final ClientRepository clientRepository;

    @GetMapping()
    String getAllUserViewPage(Model model) {
        model.addAttribute("client", clientRepository.findAll());
        return PAGE_CLIENT_VIEW;
    }
}
