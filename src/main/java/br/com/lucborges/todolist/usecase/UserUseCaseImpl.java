package br.com.lucborges.todolist.usecase;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
        String passwordCrypt = cryptUserPassword(user.getPassword());
        user.setPassword(passwordCrypt);
        return userRepository.save(user);
    }

    public String cryptUserPassword(String password) {
        return BCrypt.withDefaults()
                .hashToString(12, password.toCharArray());
    }
}
