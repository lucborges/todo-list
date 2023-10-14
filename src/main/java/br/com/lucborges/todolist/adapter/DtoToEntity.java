package br.com.lucborges.todolist.adapter;

import br.com.lucborges.todolist.entity.User;
import br.com.lucborges.todolist.entity.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
public class DtoToEntity {
    public User userDtoToUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }
}
