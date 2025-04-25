package com.productapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProduceService {

	// //no need to config this bean urself for k, v as string
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void produce(String message) {
		System.out.println("message is send....");

		CompletableFuture<SendResult<String, String>> future =
				kafkaTemplate.send("productapp-topic", message);

		future.whenComplete(((result, ex) -> {
			if(ex==null){
				System.out.println(result.getRecordMetadata().offset());//:)
			}else {
				System.out.println(ex.getMessage());
			}
		}));
	}
}