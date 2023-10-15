package br.com.lucborges.todolist.usecase;

import br.com.lucborges.todolist.entity.Todo;
import br.com.lucborges.todolist.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoUseCaseImpl implements TodoUseCase{
    @Autowired
    private ITodoRepository todoRepository;
    @Override
    public Todo todoCreate(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> listTodo(UUID userId) {
        return todoRepository.findByUserId(userId);
    }
}
