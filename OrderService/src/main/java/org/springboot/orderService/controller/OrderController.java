package org.springboot.orderService.controller;


import org.springboot.orderService.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController 
{

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    public OrderController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) 
    {
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
        return ResponseEntity.ok("✅ Order sent to RabbitMQ: " + order.getOrderId());
    }
}
