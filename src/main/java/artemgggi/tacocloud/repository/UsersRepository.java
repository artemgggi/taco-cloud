package artemgggi.tacocloud.repository;

import artemgggi.tacocloud.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, String> {
    Users findByUsername(String username);
}
