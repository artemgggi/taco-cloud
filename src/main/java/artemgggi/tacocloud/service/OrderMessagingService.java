package artemgggi.tacocloud.service;

import artemgggi.tacocloud.model.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder tacoOrder);
}
