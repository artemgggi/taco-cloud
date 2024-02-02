//package artemgggi.tacocloud.service.kafka;
//
//import artemgggi.tacocloud.model.TacoOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaOrderListener {
//
//    private KitchenUI ui;
//
//    @Autowired
//    public KafkaOrderListener(KitchenUI ui) {
//        this.ui = ui;
//    }
//
//    @KafkaListener(topics = "tacocloud.TestTopic")
//    public void handle(TacoOrder order) {
//        ui.displayOrder(order);
//    }
//}
