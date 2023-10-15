package br.com.lucborges.todolist.repository;

import br.com.lucborges.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITodoRepository extends JpaRepository<Todo, UUID> {
}
