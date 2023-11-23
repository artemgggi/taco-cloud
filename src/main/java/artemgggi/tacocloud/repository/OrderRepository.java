package artemgggi.tacocloud.repository;

import artemgggi.tacocloud.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
