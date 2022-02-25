package nz.co.challenge.javatasksapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping("")
    public String index() {
        return "<html><head></head><body><a href=\"/swagger-ui/index.html\">Swagger Documentation.</a>";
    }
}
