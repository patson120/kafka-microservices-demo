// package net.javaguide.orderservice.config;

// import java.util.HashMap;
// import java.util.Map;

// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
// import org.springframework.kafka.config.KafkaListenerContainerFactory;
// import org.springframework.kafka.core.ConsumerFactory;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
// import org.springframework.kafka.support.serializer.JsonDeserializer;



// @Configuration
// public class KafkaConsumerConfig {

//     @Value("${spring.kafka.consumer.bootstrap-servers}")
//     private String bootstrapServer;

//     @Value("${spring.kafka.consumer.group-id}")
//     private String groupid;


//     /// Construct
//     public Map<String, Object> consumerConfig(){
//         Map<String, Object> props = new HashMap<>();
//         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
//         props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//         props.put(ConsumerConfig.GROUP_ID_CONFIG, groupid);
//         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//         return props;
//     }

//     @Bean
//     ConsumerFactory<String, String> consumerFactory(){
//         return new DefaultKafkaConsumerFactory<>(consumerConfig());
//     }

//     @Bean
//     KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory(){
//         ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//         factory.setConsumerFactory(consumerFactory());
//         return factory;
//     }

// }