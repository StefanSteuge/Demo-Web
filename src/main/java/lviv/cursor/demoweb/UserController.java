package lviv.cursor.demoweb;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    List<String> users = new ArrayList();

    @PostConstruct
    public void init(){
        users.add("Ivan");
        users.add("Taras");
    }

    @GetMapping
    public List<String> users(){
        return users;
    }

    @PostMapping
    public void createUser(@RequestBody String user){
    users.add(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        users.remove(users.get(id));
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable Integer id){
        return users.get(id);
    }
}
