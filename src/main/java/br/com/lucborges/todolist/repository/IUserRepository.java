package br.com.lucborges.todolist.repository;

import br.com.lucborges.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
