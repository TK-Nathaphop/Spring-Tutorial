package tkstudy.restservice.accessingDB;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tkstudy.restservice.accessingDB.domain.User;
import tkstudy.restservice.accessingDB.dto.CreateUserDto;

@Controller
@RequestMapping(path = "/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping()
  public @ResponseBody
  String createUser(@RequestBody CreateUserDto createUserDto) {
    return this.userService.createUser(createUserDto);
  }

  @GetMapping(path = "/all")
  public @ResponseBody
  Iterable<User> getAllUser() {
    return userService.getAllUser();
  }

  @PutMapping()
  public @ResponseBody
  User updateNameById(@RequestParam Integer id, @RequestParam String name) {
    return userService.updateNameById(id, name);
  }

  @DeleteMapping()
  public @ResponseBody
  String deleteUserById(@RequestParam Integer id) {
    return userService.deleteUserById(id);
  }

  @GetMapping()
  public @ResponseBody
  Optional<User> getUserById(@RequestParam Integer id) {
    return userService.getUserById(id);
  }

}
