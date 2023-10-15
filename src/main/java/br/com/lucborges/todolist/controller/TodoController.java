package br.com.lucborges.todolist.controller;

import br.com.lucborges.todolist.adapter.DtoToEntity;
import br.com.lucborges.todolist.entity.TodoDto;
import br.com.lucborges.todolist.usecase.TodoUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    private DtoToEntity adapter;
    @Autowired
    private TodoUseCase todoUseCase;
    @PostMapping(value = "/todo")
    public ResponseEntity create(@RequestBody TodoDto todoDto, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoUseCase.todoCreate(
                        adapter.todoDtoToTodo(todoDto, request.getAttribute("userId"))));
    }
}
