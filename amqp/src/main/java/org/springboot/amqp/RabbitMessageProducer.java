package org.springboot.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMessageProducer 
{
	private AmqpTemplate amqpTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(RabbitMessageProducer.class);
	
	public void publish(Object payload, String exchange, String routingKey) 
	{
        //log.info("Publishing to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routingKey {}. Payload: {}", exchange, routingKey, payload);
    }

}
