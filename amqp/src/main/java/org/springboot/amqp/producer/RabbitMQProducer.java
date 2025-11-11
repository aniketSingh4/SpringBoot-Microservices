package org.springboot.amqp.producer;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer 
{
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("{rabbitmq.routing.key}")
	private String routingKey;
	
	private RabbitTemplate template;
	
	private Logger log;

	
	
	public RabbitMQProducer(RabbitTemplate template) 
	{
		super();
		this.template = template;
	}



	public void sendMessage(String message)
	{
		log.info(String.format("Message Send -> %s", message));
		template.convertAndSend(message, message, message);
	}

}
