// package net.javaguide.orderservice.config;

// import org.apache.kafka.clients.admin.NewTopic;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.config.TopicBuilder;

// @Configuration
// public class KafkaTopicConfig {

//     @Value("${spring.kafka.topic.name}")
//     private String topicName;

//     // Spring bean for kafka topic
//     @Bean
//     NewTopic topic() {
//         return TopicBuilder.name(topicName).build();
//     }

//     private static final String RESPONSE_TOPIC_NAME = "response-topic";

//     @Bean
//     NewTopic responseTopic() {
//         // Créer le topic de réponse avec une seule partition et une réplication
//         return new NewTopic(RESPONSE_TOPIC_NAME, 1, (short) 1);
//     }

// }
