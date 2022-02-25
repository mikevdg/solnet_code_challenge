package nz.co.challenge.javatasksapi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    // TODO: not sure about whether this api is properly REST.
    @PostMapping("/")
    public Optional<Task> createTask(Task t) {
        taskRepository.save(t);
        return Optional.of(t);
    }

    @PutMapping("/{id}")
    public Optional<Task> modifyTask(Task t, @PathVariable Long id) {
        taskRepository.save(t);
        return Optional.of(t);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVaraible Long id) {
        if (null==id) {
            // TODO: throw an error of some sort. An exception?
            return;
        }
        taskRepository.deleteById(id);
    }
}
