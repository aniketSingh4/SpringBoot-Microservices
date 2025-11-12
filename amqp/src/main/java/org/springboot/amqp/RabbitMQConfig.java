package org.springboot.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig 
{

    private final ConnectionFactory connectionFactory;

    public RabbitMQConfig(ConnectionFactory connectionFactory) 
    {
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public AmqpTemplate amqpTemplate(MessageConverter messageConverter) 
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(MessageConverter messageConverter) 
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        // Optional modern tuning:
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        factory.setDefaultRequeueRejected(false);
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() 
    {
        return new Jackson2JsonMessageConverter();
    }
}



























//@Configuration
//public class RabbitMQConfig 
//{
//	@Value("${rabbitmq.queue.name}")
//	private String queue;
//	
//	@Value("${rabbitmq.exchange.name}")
//	private String exchange;
//	
//	@Value("{rabbitmq.routing.key}")
//	private String routingKey;
//	
//	//Creating a Queue for storing Messages
//	@Bean
//	public Queue queue()
//	{
//		return new Queue(queue);
//	}
//	
//	//to set exchange rules
//	@Bean
//	public TopicExchange exchange()
//	{
//		return new TopicExchange(exchange);
//	}
//	
//	@Bean
//	public Binding binding(Queue queue, TopicExchange exchange)
//	{
//		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
//	}
//
//}
