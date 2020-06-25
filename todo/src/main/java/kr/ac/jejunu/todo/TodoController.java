package kr.ac.jejunu.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoDao todoDao;

    @GetMapping("/todo")
    public List<Todo> get() {
        return todoDao.findAll();
    }

    @PostMapping("/save")
    public Todo create(@RequestBody Todo todo){
        return todoDao.save(todo);
    }

    @PutMapping("/save")
    public Todo modify(@RequestBody Todo todo){
        return todoDao.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        todoDao.delete(todoDao.findById(id).get());
    }

}
