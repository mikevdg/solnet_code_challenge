package nz.co.challenge.javatasksapi.task;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue
    public Long id;

    @Column(length=256, nullable=false)
    public String title;

    @Column(length=1024)
    public String description;

    @Column(name="due_date", columnDefinition = "DATE")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    public Date dueDate;

    @Column(length=10)
    public String status; 

    @Column(name="creation_date", columnDefinition="DATE", nullable=false)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    public Date creationDate;
}
