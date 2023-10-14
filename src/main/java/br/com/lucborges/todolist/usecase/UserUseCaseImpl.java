package br.com.lucborges.todolist.usecase;

import br.com.lucborges.todolist.entity.User;
import br.com.lucborges.todolist.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserUseCaseImpl implements UserUseCase{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User userCreate(User user) {
        return userRepository.save(user);
    }
}
