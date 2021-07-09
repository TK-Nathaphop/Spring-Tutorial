package tkstudy.restservice.accessingDB;

import java.util.Optional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tkstudy.restservice.accessingDB.domain.User;
import tkstudy.restservice.accessingDB.domain.UserRepository;
import tkstudy.restservice.accessingDB.dto.CreateUserDto;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Cacheable(value = "user", key = "#id")
  public Optional<User> getUserById(Integer id) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      System.out.println("Thread sleep error");
    }
    return this.userRepository.findById(id);
  }

  @CacheEvict(value = "user", key = "#id")
  public String deleteUserById(Integer id) {
    try {
      userRepository.deleteById(id);
    } catch (Exception e) {
      return "Error, cannot delete user by id:" + id;
    }
    return "Deleted";
  }

  @CachePut(value = "user", key = "#id")
  public User updateNameById(Integer id, String name) {
    Optional<User> queryUser = userRepository.findById(id);
    if (!queryUser.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    User user = queryUser.get();
    user.setName(name);
    user = userRepository.save(user);
    return user;

  }

  public String createUser(CreateUserDto createUserDto) {
    User user = new User();
    user.setName(createUserDto.getName());
    user.setEmail(createUserDto.getEmail());
    userRepository.save(user);
    return "Success";
  }

  public Iterable<User> getAllUser() {
    return this.userRepository.findAll();
  }

}
