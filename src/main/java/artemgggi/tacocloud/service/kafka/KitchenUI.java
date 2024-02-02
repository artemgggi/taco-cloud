package artemgggi.tacocloud.service.kafka;

import artemgggi.tacocloud.model.TacoOrder;
import org.springframework.stereotype.Component;

@Component
public class KitchenUI {

    public TacoOrder displayOrder(TacoOrder order) {
        return order;
    }
}
