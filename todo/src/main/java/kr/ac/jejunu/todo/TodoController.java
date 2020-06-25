package kr.ac.jejunu.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoDao todoDao;

    @GetMapping()
    public List<Todo> get() {
        return todoDao.findAll();
    }

    @RequestMapping(path = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public Todo create(@RequestBody Todo todo){
        return todoDao.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        todoDao.delete(todoDao.findById(id).get());
    }

}
