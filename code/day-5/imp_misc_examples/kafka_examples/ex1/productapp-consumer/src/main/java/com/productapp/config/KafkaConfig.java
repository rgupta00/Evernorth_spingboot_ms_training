package com.productapp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name("productapp-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
