package br.com.lucborges.todolist.usecase;

import br.com.lucborges.todolist.entity.Todo;

import java.util.List;
import java.util.UUID;

public interface TodoUseCase {
    Todo todoCreate(Todo todo);
    List<Todo> listTodo(UUID userId);
}
