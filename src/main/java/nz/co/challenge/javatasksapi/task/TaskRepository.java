package nz.co.challenge.javatasksapi.task;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource()
public interface TaskRepository  extends PagingAndSortingRepository<Task, Long> {
}