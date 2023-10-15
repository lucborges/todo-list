package br.com.lucborges.todolist.usecase;

import br.com.lucborges.todolist.entity.Todo;
import br.com.lucborges.todolist.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoUseCaseImpl implements TodoUseCase{
    @Autowired
    private ITodoRepository todoRepository;
    @Override
    public Todo todoCreate(Todo todo) {
        return todoRepository.save(todo);
    }
}
