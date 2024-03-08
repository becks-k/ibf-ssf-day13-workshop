package ibf2023.ssf.day13.models;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Task {
    
    @NotNull(message = "Task cannot be null")
    @Size(min=1, max=100, message = "Fill in a task!")
    private String task;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    private Integer priority;

    @FutureOrPresent(message = "Date must be present or future")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private LocalDate dueDate;

    
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task [task=" + task + ", priority=" + priority + ", dueDate=" + dueDate + "]";
    }
    
}
