// package net.javaguide.stockservice.config;

// import org.apache.kafka.clients.admin.NewTopic;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.config.TopicBuilder;

// @Configuration
// public class KafkaTopicConfig {


//     // Spring bean for kafka topic
//     @Bean 
//     NewTopic topic(){
//         return TopicBuilder.name("order_topics").build();
//     }

//     @Bean 
//     NewTopic responseTopic(){
//         return TopicBuilder.name("topic-response").build();
//     }
// }
