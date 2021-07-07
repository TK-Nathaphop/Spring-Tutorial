package tkstudy.restservice.accessingDB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tkstudy.restservice.accessingDB.domain.User;
import tkstudy.restservice.accessingDB.dto.CreateUserDto;
import tkstudy.restservice.accessingDB.dto.UpdateUserDto;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public @ResponseBody String createUser(@RequestBody CreateUserDto createUserDto){
        return this.userService.createUser(createUserDto);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping()
    public @ResponseBody User updateNameById(@RequestParam Integer id, @RequestParam String name){
        return userService.updateNameById(id, name);
    }

    @DeleteMapping()
    public @ResponseBody String deleteUserById(@RequestParam Integer id){
        return userService.deleteUserById(id);
    }

    @GetMapping()
    public @ResponseBody Optional<User> getUserById(@RequestParam Integer id){
        return userService.getUserById(id);
    }

}
