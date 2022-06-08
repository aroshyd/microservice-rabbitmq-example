package a.roshyd.service;

import a.roshyd.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    private final RabbitTemplate template;


    @Autowired
    public RabbitMQSender(RabbitTemplate template) {
        this.template = template;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    public void send(User user){
        template.convertAndSend(exchange,routingKey,user);
    }



}
