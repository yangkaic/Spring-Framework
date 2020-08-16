package com.kaicheng.springbootkafkademo.restcontrolelr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kaicheng.springbootkafkademo.model.SimpleModel;

@RestController
@RequestMapping("/api/kafka")
public class KafkaRestController {
	
	@Autowired
	public KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private Gson jsonConverter;
	
	@GetMapping("/produce/messages")
	public SimpleModel get() {
		return new SimpleModel("Hello", "World");
	}
	
	@PostMapping("/produce/messages")
	public void post(@RequestBody SimpleModel simpleModel) {
		kafkaTemplate.send("myTopic", jsonConverter.toJson(simpleModel));
	}
	
	@KafkaListener(topics = "myTopic")
	public void getFromKafka(String message) {
		System.out.println(message);
		
		SimpleModel simpleModel = 
				(SimpleModel) jsonConverter.fromJson(message, SimpleModel.class);
		System.out.println(simpleModel);
	}
	

}
