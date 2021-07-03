package tkstudy.restservice.accessingDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tkstudy.restservice.accessingDB.dto.UserCreateDto;

@Controller
@RequestMapping(path = "/user")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Success";
    }

    @PostMapping(path="/addWithRequestBody")
    public @ResponseBody String addNewUser(@RequestBody UserCreateDto userCreateDto){
        User user = new User();
        user.setName(userCreateDto.getName());
        user.setEmail(userCreateDto.getEmail());
        userRepository.save(user);
        return "Success";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

}
