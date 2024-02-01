package artemgggi.tacocloud.service;

import artemgggi.tacocloud.model.TacoOrder;

public interface OrderMassagingService {

    void sendOrder(TacoOrder tacoOrder);
}
