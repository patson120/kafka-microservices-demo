package net.javaguide.stockservice.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguide.basedomains.config.KafkaConfiguration;
import net.javaguide.basedomains.dto.OrderEvent;

@Service
public class OrderConsumer {

     @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    private KafkaConfiguration kafkaConfiguration = new KafkaConfiguration();

    @KafkaListener(topics = "request-topic", groupId = "my-group")
    public void receiveMessage(String message) {

        // Configurer les propriétés du producer
        Properties producerProps = kafkaConfiguration.procedureProperties(bootstrapServer);

        ObjectMapper mapper = new ObjectMapper();
        try {
            OrderEvent event = mapper.readValue(message, OrderEvent.class);

            // Créer le producer et envoyer la demande
            KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps);
            ProducerRecord<String, String> record = new ProducerRecord<>(event.getReplyTopic(),
                    event.getOrder().getOrderId(), mapper.writeValueAsString(event));
            producer.send(record).get();

        } catch (InterruptedException | ExecutionException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
