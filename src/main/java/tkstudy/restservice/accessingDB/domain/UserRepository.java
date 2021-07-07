package tkstudy.restservice.accessingDB.domain;

import org.springframework.data.repository.CrudRepository;
import tkstudy.restservice.accessingDB.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
