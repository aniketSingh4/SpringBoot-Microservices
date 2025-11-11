package org.springboot.amqp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer 
{
	
	//private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void recievedMessage(String message)
	{
		logger.info(String.format("Message Received: " + message));
	}

}

