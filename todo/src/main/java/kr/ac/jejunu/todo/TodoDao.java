package kr.ac.jejunu.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDao extends JpaRepository<Todo, Integer> {
}
