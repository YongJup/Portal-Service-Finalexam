package kr.ac.jejunu.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoDao todoDao;

    @GetMapping("/todo")
    public List<Todo> get() {
        return todoDao.findAll();
    }
}