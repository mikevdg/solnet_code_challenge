package nz.co.challenge.javatasksapi.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/")
    public String index() {
        return "Tasks controller";
    }
}
