package nz.co.challenge.javatasksapi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/overdue")
    public Iterable<Task> overdue() {
        return taskRepository.findOverdue();
    }

    @GetMapping("/")
    public Iterable<Task> index() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task t) {
        t.creationDate = new Date(); // Today.
        taskRepository.save(t);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> modifyTask(@RequestBody Task t, @PathVariable Long id) {
        Task orig = taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        t.creationDate = orig.creationDate;
        taskRepository.save(t);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        if (null==id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id must be provided.");
        }
        taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        taskRepository.deleteById(id);
    }
}
