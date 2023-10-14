package br.com.lucborges.todolist.controller;

import br.com.lucborges.todolist.adapter.DtoToEntity;
import br.com.lucborges.todolist.entity.User;
import br.com.lucborges.todolist.entity.UserDto;
import br.com.lucborges.todolist.repository.IUserRepository;
import br.com.lucborges.todolist.usecase.UserUseCase;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private DtoToEntity adapter;

    @Autowired
    private UserUseCase userUseCase;

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody UserDto userDto) {
        User user = adapter.userDtoToUser(userDto);
        User isUser = userRepository.findByUsername(user.getUsername());
        if (isUser != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Usuário já existe");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userUseCase.userCreate(user));
    }
}
