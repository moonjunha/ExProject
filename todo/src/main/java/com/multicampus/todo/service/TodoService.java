package com.multicampus.todo.service;

import com.multicampus.todo.dao.TodoDAO;
import com.multicampus.todo.domain.TodoVO;
import com.multicampus.todo.dto.TodoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoService implements ITodoService{

    @Autowired
    private TodoDAO dao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(mapper);
        TodoVO vo=mapper.map(todoDTO,TodoVO.class);
        log.info(vo);
        dao.insert(vo);
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = dao.selectAll().stream()
                .map(vo -> mapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = mapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {
        dao.delete(tno);
    }
}
