package artemgggi.tacocloud.repository;

import artemgggi.tacocloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, String> {
    User findByUsername(String username);
}