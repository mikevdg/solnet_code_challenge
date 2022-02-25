package nz.co.challenge.javatasksapi.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

// TODO: Properly annotate this.

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length=256, nullable=false)
    private String title; // 256

    @Column(length=1024)
    private String description; // 1024

    @Column(name="due_date", columnDefinition = "DATE")
    private Date dueDate;

    @Column(length=10)
    private String status; // 10;

    @Column(name="creation_date", columnDefinition="DATE", nullable=false)
    private Date creationDate;
}
