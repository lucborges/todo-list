package br.com.lucborges.todolist.usecase;

import br.com.lucborges.todolist.entity.User;
import org.springframework.stereotype.Service;

public interface UserUseCase {
    User userCreate(User user);
}
