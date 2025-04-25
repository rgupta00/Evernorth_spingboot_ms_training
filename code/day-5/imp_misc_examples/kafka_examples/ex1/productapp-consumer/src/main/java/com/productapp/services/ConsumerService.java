package com.productapp.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	@KafkaListener(topics = "productapp-topic", groupId = "my_topic_group_id")
	public void consume(String message) {
		System.out.println(message);
	}

}
