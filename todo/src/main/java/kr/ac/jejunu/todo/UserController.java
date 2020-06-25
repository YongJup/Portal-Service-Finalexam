package kr.ac.jejunu.todo;

import com.google.gson.JsonObject;
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

    @PostMapping("/login")
    public String login(@RequestBody() User user){

        String email = user.getEmail();
        String password = user.getPassword();

        User findUser = userDao.findByEmail(user.getEmail()).orElseThrow(() -> new IllegalArgumentException("이메일 확인"));
        if(password.equals(findUser.getPassword())) {

            JsonObject obj = new JsonObject();

            double token;
            token = Math.random();

            findUser.setToken(token);
            userDao.save(findUser);

            obj.addProperty("token", token);
            obj.addProperty("email", email);
            obj.addProperty("password", password);
            return obj.toString();
        }else {
            throw new IllegalArgumentException("비밀번호 확인");
        }
    }

}
