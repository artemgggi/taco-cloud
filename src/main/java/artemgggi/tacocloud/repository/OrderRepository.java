package artemgggi.tacocloud.repository;

import artemgggi.tacocloud.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<TacoOrder, String> {
}
