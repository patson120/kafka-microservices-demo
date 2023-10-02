// package net.javaguide.stockservice.component;

// import org.apache.kafka.clients.consumer.ConsumerRecord;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Component;

// @Component
// public class Consumer {

//     private static final String REQUEST_TOPIC_NAME = "request-topic";
//     private static final String RESPONSE_TOPIC_NAME = "response-topic";

//     @Autowired
//     private KafkaTemplate<String, String> kafkaTemplate;

//     @KafkaListener(topics = REQUEST_TOPIC_NAME)
//     public void listen(ConsumerRecord<String, String> record) {
//         // Traiter

//         System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//         System.err.println("Message reçu dans le consumer record");
//         System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

//     }
// }
