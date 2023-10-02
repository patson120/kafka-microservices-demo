// package net.javaguide.stockservice.controller;

// import org.apache.kafka.clients.admin.NewTopic;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Service;

// @Service
// public class StockProducer {
//     private static final Logger LOGGER = LoggerFactory.getLogger(StockProducer.class);

//     private NewTopic topic;

//     private KafkaTemplate<String, String> kafkaTemplate;

//     public StockProducer(NewTopic topic, KafkaTemplate<String, String> kafkaTemplate) {
//         this.topic = topic;
//         this.kafkaTemplate = kafkaTemplate;
//     }

//     public void sendMessage(String event) {
//         LOGGER.info(String.format("Stock event => %s", event));

//         // Create message
//         // Message<OrderEvent> message = MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, topic.name())
//         //         .build();

//         // ObjectMapper mapper = new ObjectMapper();
//         try {
//             kafkaTemplate.send("topic-response", event);
//             System.err.println(">>>>>>>>>>>>>>>>>>>>>>> SEND ");
//         } catch (Exception e) {
//             System.err.println(">>>>>>>>>>>>>>>>>>>>>>>ERROR: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }
    
// }