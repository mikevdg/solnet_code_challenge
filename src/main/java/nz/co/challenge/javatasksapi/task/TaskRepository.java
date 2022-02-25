package nz.co.challenge.javatasksapi.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource() - interesting, but cheating.
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query("SELECT t from Task t where t.dueDate < CURRENT_DATE")
    Collection<Task> findOverdue();
}