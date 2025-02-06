package com.project.to_do_list.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;

    public boolean getCompleted(){
        return completed;
    }
}
