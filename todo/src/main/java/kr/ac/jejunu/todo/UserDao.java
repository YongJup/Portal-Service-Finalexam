package kr.ac.jejunu.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository <User, Integer> {
}
