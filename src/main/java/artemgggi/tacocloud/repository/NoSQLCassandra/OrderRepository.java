package artemgggi.tacocloud.repository.NoSQLCassandra;

import artemgggi.tacocloud.model.NoSQLCassandra.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository
        extends CrudRepository<TacoOrder, UUID> {
}
