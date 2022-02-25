package nz.co.challenge.javatasksapi.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource()
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    @Query("SELECT t from Task t where t.dueDate < CURRENT_DATE")
    Collection<Task> findOverdue();
}