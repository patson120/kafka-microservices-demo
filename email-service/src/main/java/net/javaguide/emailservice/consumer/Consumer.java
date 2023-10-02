package net.javaguide.emailservice.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguide.basedomains.dto.OrderEvent;

@Component
public class Consumer {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    @KafkaListener(topics = "request-topic", groupId = "my-group-1")
    public void receiveMessage(String message) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            OrderEvent event = mapper.readValue(message, OrderEvent.class);
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> Je suis dans le service d'email >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.err.println(event.toString());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        } catch ( JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
