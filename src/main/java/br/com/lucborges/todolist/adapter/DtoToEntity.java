package br.com.lucborges.todolist.adapter;

import br.com.lucborges.todolist.entity.Todo;
import br.com.lucborges.todolist.entity.TodoDto;
import br.com.lucborges.todolist.entity.User;
import br.com.lucborges.todolist.entity.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DtoToEntity {
    public User userDtoToUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }

    public Todo todoDtoToTodo(TodoDto todoDto, Object userId) {
        ModelMapper mapper = new ModelMapper();
        Todo todo = mapper.map(todoDto, Todo.class);
        todo.setUserId((UUID) userId);
        return todo;
    }
}
