package org.springboot.orderService.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.orderService.dto.OrderNotification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

public class NotificationProducer 
{
	@Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    
	private RabbitTemplate rabbitTemplate;

	public NotificationProducer(RabbitTemplate rabbitTemplate) 
	{
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProducer.class);
	
	public void sendNotification(OrderNotification order)
	{
		String message = order.getOrderId() + " " + order.getItemName() + " " + 
						 order.getQuantity();
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		
		LOGGER.info("Order Created:- "+message);
	}
	
	

}
