package net.javaguide.orderservice.services;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.javaguide.basedomains.config.KafkaConfiguration;
import net.javaguide.basedomains.dto.OrderEvent;

@Service
public class MyService {

    private KafkaConfiguration kafkaConfiguration = new KafkaConfiguration();


    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServer;

    String responseTopic = "response-topic";
    String requestTopic = "request-topic";

    @Async
    public OrderEvent sendMessageAndWaitForResponse(OrderEvent event) {

        try {
            // Configurer les propriétés du producer
            Properties producerProps = kafkaConfiguration.procedureProperties(bootstrapServer);

            // Configurer les propriétés du consumer
            Properties consumerProps = kafkaConfiguration.consumerProperties(bootstrapServer, "my-group");

            // Créer le producer et envoyer la demande
            KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps);

            String myCorrelationId = event.getOrder().getOrderId();
            event.setReplyTopic(responseTopic);
            ObjectMapper mapper = new ObjectMapper();

            String message = mapper.writeValueAsString(event);
            ProducerRecord<String, String> record = new ProducerRecord<>(requestTopic, event.getOrder().getOrderId(),
                    message);
            producer.send(record).get();
            producer.close();

            // Créer le consumer et attendre la réponse
            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);
            consumer.subscribe(Collections.singletonList(responseTopic));
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMinutes(5));
            String reply = null;
            OrderEvent response = null;
            while (reply == null) {
                for (ConsumerRecord<String, String> r : records) {
                    response = mapper.readValue(r.value(), OrderEvent.class);
                    if (response.getOrder().getOrderId().equals(myCorrelationId)) {
                        reply = r.value();
                        break;
                    }
                }
            }
            consumer.close();

            return response;
        } catch (InterruptedException | ExecutionException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }
}