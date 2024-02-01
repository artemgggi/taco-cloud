package artemgggi.tacocloud.service;

import artemgggi.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderReceiverService implements OrderReceiverService {

    private final JmsTemplate jms;
    private final MessageConverter converter;

    @Autowired
    public JmsOrderReceiverService(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }

    @Override
    public TacoOrder receiveOrder() {
        return (TacoOrder) jms.receiveAndConvert("tacocloud.order.queue");
    }
}
