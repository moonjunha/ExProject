package com.multicampus.todo.controller;

import com.multicampus.todo.dto.TodoDTO;
import com.multicampus.todo.service.ITodoService;
import com.multicampus.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Log4j2
public class TodoController {

    @Autowired
    TodoService todoService;

    private  final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @GetMapping("/custom404")
    public String getCustom404() {
        log.info("=====> getCustom404");
        return "custom404";
    }

    @GetMapping("/todo/list")
    public String getList(Model model) {
        log.info("=====> getList");
        System.out.println(todoService.getAll());
        model.addAttribute("dtolist",todoService.getAll());
        return "todo/list";
    }

    @GetMapping({"todo/read", "todo/modify"})
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO );

    }

    @GetMapping("/todo/registerForm")
    public String register(Model model, HttpServletRequest request){

        return "todo/registerForm";
    }

    @PostMapping("/todo/register")
    public String registerWrite(Model model, HttpServletRequest request){
        TodoDTO todoDTO = TodoDTO.builder()
                .writer(request.getParameter("writer"))
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATETIMEFORMATTER))
                .build();

        todoService.register(todoDTO);
        return "todo/list";
    }

    @PostMapping("todo/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){
        log.info("-------------remove------------------");
        log.info("tno: " + tno);
        todoService.remove(tno);
        return "redirect:/todo/list";
    }

}