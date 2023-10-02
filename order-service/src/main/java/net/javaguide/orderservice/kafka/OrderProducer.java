// package net.javaguide.orderservice.kafka;

// import org.apache.kafka.clients.admin.NewTopic;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.kafka.core.ConsumerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.support.KafkaHeaders;
// import org.springframework.messaging.Message;
// import org.springframework.messaging.support.MessageBuilder;
// import org.springframework.stereotype.Service;

// import net.javaguide.basedomains.dto.OrderEvent;

// @Service
// public class OrderProducer {

//     private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

//     private NewTopic topic;
//     private KafkaTemplate<String, String> kafkaTemplate;
//     private final ConsumerFactory<String, String> consumerFactory;

//     public OrderProducer(NewTopic topic, KafkaTemplate<String, String> kafkaTemplate,
//             ConsumerFactory<String, String> consumerFactory) {
//         this.topic = topic;
//         this.kafkaTemplate = kafkaTemplate;
//         this.consumerFactory = consumerFactory;
//     }

//     public void sendMessage(OrderEvent event) {
//         LOGGER.info(String.format("Order event => %s", event.toString()));

//         // Create message $
//         Message<String> message = MessageBuilder.withPayload(event.toString())
//                 .setHeader(KafkaHeaders.TOPIC, topic.name())
//                 .setHeader(KafkaHeaders.REPLY_TOPIC, "topic-response")
//                 .build();
//         kafkaTemplate.send(message);


//         // Récupère la réponse
//         // Consumer<String, String> consumer = consumerFactory.createConsumer();
//         // consumer.subscribe(Collections.singletonList("topic-response"));
//         // ConsumerRecord<String, String> record = kafkaTemplate.receive("topic-response", 0, 0, Duration.ofSeconds(60));
//         // if (record != null) {
//         //     // Traite la réponse
//         //     String response = record.value();
//         //     System.out.println("Réponse reçue : " + response);
//         // }
//         // consumer.close();
//     }

    

// }
