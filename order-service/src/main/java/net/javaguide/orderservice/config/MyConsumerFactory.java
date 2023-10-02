// package net.javaguide.orderservice.config;

// import org.apache.kafka.clients.consumer.Consumer;
// import org.apache.kafka.clients.consumer.KafkaConsumer;
// import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
// // import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.core.ConsumerFactory;

// @Configuration
// public class MyConsumerFactory implements ConsumerFactory<String, String> {

//     private final KafkaProperties kafkaProperties;

//     public MyConsumerFactory(KafkaProperties kafkaProperties) {
//         this.kafkaProperties = kafkaProperties;
//     }

//     @Override
//     public Consumer<String, String> createConsumer(String groupId, String clientIdPrefix, String clientIdSuffix) {
//        return new KafkaConsumer<>(kafkaProperties.buildConsumerProperties());
//     }

//     @Override
//     public boolean isAutoCommit() {
//         return false;
//     }
// }