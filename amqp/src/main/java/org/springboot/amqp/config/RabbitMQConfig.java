package org.springboot.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig 
{
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("{rabbitmq.routing.key}")
	private String routingKey;
	
	//Creating a Queue for storing Messages
	@Bean
	public Queue queue()
	{
		return new Queue(queue);
	}
	
	//to set exchange rules
	@Bean
	public TopicExchange exchange()
	{
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

}
