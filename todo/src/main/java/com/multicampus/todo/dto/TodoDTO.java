package com.multicampus.todo.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Builder
@Data   //geter,setter,tostring,equals,hashcode 포함
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
    private Long tno;

    @NotEmpty
    private String title;

    @Future
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer;
}
