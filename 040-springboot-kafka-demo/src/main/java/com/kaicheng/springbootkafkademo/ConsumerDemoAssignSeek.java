package com.kaicheng.springbootkafkademo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class ConsumerDemoAssignSeek {
	
	public static void main(String[] args) {
		
		//Logger logger = LoggerFactory.getLogger(ConsumerDemo.class);
		Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
		logger.setLevel(Level.INFO);
		
		Properties properties = new Properties();
		
		String bootstrapServers = "127.0.0.1:9092";
//		String groupId = "my-seventh-application"; no groupId there in AssignSeek
		String topic = "first_topic";
		
		// create consumer configs
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		//create consumer
		KafkaConsumer<String, String> consumer = 
				new KafkaConsumer<>(properties);
		
		// subscribe consumer to our topic(s)
		//consumer.subscribe(Arrays.asList(topic)); no this in AssignSeek
		
		// assign and seek are mostly used to replay data or fetch a specific message
		// assign
		TopicPartition partitionToReadFrom = new TopicPartition(topic, 0);
		long offsetToReadFrom = 15L;
		consumer.assign(Arrays.asList(partitionToReadFrom));
		
		//seek
		consumer.seek(partitionToReadFrom, offsetToReadFrom);
		
		int numberOfMessagesToRead = 5;
		boolean keepOnReading = true;
		int numberOfMessagesReadSoFar = 0;
		
		// poll for new data
		while (keepOnReading) {
			//consumer.poll(100); deprecated
			ConsumerRecords<String, String> records = 
					consumer.poll(Duration.ofMillis(100)); // new in Kafka 2.0.0
			
			for (ConsumerRecord<String, String> record : records) {
				numberOfMessagesReadSoFar++;
				logger.info("Key: " + record.key() + ", Value: " + record.value());
				logger.info("Partition: " + record.partition() + ", Offset: " + record.offset());
				if (numberOfMessagesReadSoFar >= numberOfMessagesToRead) {
					keepOnReading = false; // to exit the while loop
					break; // to exit the for loop
				}
			}
		}
		logger.info("Exiting the application");
		
	}

}
