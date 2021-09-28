package pl.WojtekMalka.csvReader.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.WojtekMalka.csvReader.message.ResponseMessage;
import pl.WojtekMalka.csvReader.service.ClientService;
import pl.WojtekMalka.csvReader.service.FileReader;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class LoadControllerREST {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadControllerREST.class);

    private final ClientService clientService;

    @PostMapping("/loadFile")
    ResponseEntity<ResponseMessage> loadFile(@RequestParam("file") MultipartFile file) {
        if (FileReader.hasCSVFormat(file)) {
            try {
                clientService.save(file);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                        .body(new ResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Please upload a csv file!"));
        }
    }
}