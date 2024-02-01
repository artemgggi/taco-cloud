package artemgggi.tacocloud.service;

import artemgggi.tacocloud.model.TacoOrder;
import jakarta.jms.JMSException;

public interface OrderReceiverService {

    TacoOrder receiveOrder() throws JMSException;
}
