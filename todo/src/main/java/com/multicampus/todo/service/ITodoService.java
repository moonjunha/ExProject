package com.multicampus.todo.service;

import com.multicampus.todo.dto.TodoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);
    void remove(Long tno);
}
