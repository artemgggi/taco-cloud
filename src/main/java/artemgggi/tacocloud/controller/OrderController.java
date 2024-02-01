package artemgggi.tacocloud.controller;

import artemgggi.tacocloud.model.TacoOrder;
import artemgggi.tacocloud.model.Users;
import artemgggi.tacocloud.repository.OrderRepository;
import artemgggi.tacocloud.service.OrderMassagingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderMassagingService messagingService;

    public OrderController(
            OrderRepository orderRepository,
            OrderMassagingService messagingService) {
        this.orderRepository = orderRepository;
        this.messagingService = messagingService;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal Users users) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUsers(users);
        orderRepository.save(order);
        messagingService.sendOrder(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
