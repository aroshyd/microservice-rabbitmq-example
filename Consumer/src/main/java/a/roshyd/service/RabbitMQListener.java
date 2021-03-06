package a.roshyd.service;

import a.roshyd.domain.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;



@Component
public class RabbitMQListener implements RabbitListenerConfigurer {

    private static final Logger logger= LoggerFactory.getLogger(RabbitMQListener.class);

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(UserDto userDto){
        System.out.println(userDto.getUsername());
        logger.info("User Details: "+ userDto);
    }
}
