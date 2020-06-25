package kr.ac.jejunu.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping("get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userDao.findById(id).get();
    }

    @RequestMapping(path = "/save", method = {RequestMethod.POST, RequestMethod.PUT})
    public User create(@RequestBody User user){
        return userDao.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        userDao.delete(userDao.findById(id).get());
    }

}
