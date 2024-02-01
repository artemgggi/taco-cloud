package artemgggi.tacocloud.service.rabbit;

import artemgggi.tacocloud.model.TacoOrder;
import artemgggi.tacocloud.service.OrderReceiverService;
import jakarta.jms.JMSException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitOrderReceiverService implements OrderReceiverService {

    private final RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderReceiverService(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public TacoOrder receiveOrder() throws JMSException {
        return (TacoOrder) rabbit.receiveAndConvert("tacocloud.order.queue");
    }
}
