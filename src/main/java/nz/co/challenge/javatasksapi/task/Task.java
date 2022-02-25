package nz.co.challenge.javatasksapi.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title; // 256
    private String description; // 1024
    private Date dueDate;
    private String status; // 10;
    private Date creationDate;
}
