package br.com.lucborges.todolist.controller;

import br.com.lucborges.todolist.adapter.DtoToEntity;
import br.com.lucborges.todolist.entity.Todo;
import br.com.lucborges.todolist.entity.TodoDto;
import br.com.lucborges.todolist.usecase.TodoUseCase;
import br.com.lucborges.todolist.utils.DateUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TodoController {
    @Autowired
    private DtoToEntity adapter;
    @Autowired
    private TodoUseCase todoUseCase;
    @Autowired
    private DateUtils dateUtils;

    @PostMapping(value = "/todo")
    public ResponseEntity create(@RequestBody TodoDto todoDto, HttpServletRequest request) {
        Todo todo = adapter.todoDtoToTodo(todoDto, request.getAttribute("userId"));
        if (!dateUtils.validateIsValidDate(todo.getStartAt()) || !dateUtils.validateIsValidDate(todo.getEndAt())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The start/end date must greater than current date");
        }
        if (!dateUtils.validateIsStartDateIsSmallerThanEndDate(todo.getStartAt(), todo.getEndAt())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("The start date must smaller than end date");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoUseCase.todoCreate(todo));
    }

    @GetMapping(value = "/todo")
    public List<Todo> list(HttpServletRequest request) {
        return todoUseCase.listTodo((UUID) request.getAttribute("userId"));
    }
}
