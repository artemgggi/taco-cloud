package artemgggi.tacocloud.service.artemis;

import artemgggi.tacocloud.model.TacoOrder;
import artemgggi.tacocloud.service.OrderReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsOrderReceiverService implements OrderReceiverService {

    private final JmsTemplate jms;

    @Autowired
    public JmsOrderReceiverService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public TacoOrder receiveOrder() {
        return (TacoOrder) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
