package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import com.example.demo.dto.FinancialTransaction;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfig {
     @Value("${app.kafka.topic}")
    private String topicName;

    @Bean
    public NewTopic transactionsTopic() {
        // 3 partitions, replicationFactor=1 suitable for local/dev
        return new NewTopic(topicName, 3, (short) 1);
    }

    @Bean
    public ProducerFactory<String, FinancialTransaction> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, FinancialTransaction> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
