package com.kaicheng.springbootkafkademo;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoWithKeys {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Logger logger = LoggerFactory.getLogger(ProducerDemoWithKeys.class);

		String bootstrapServers = "127.0.0.1:9092";

		// create Producer properties
		Properties properties = new Properties();

//		properties.setProperty("bootstrap.servers", bootstrapServers);
//		properties.setProperty("key.serializer", StringSerializer.class.getName());
//		properties.setProperty("value.serializer", StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		// create a producer record
		for (int i = 1; i <= 10; i++) {
			String topic = "first_topic";
			String value = "hello world" + Integer.toString(i);
			String key = "id_" + Integer.toString(i);
			
			ProducerRecord<String, String> record = new ProducerRecord<>(topic, value, key);

			logger.info("Key:" + key);// log the key
			// According to logs: 
			// id_1 is going to partition 0
			// id_2 is going to partition 2
			// ...
			
			// send data - asynchronous
			producer.send(record, new Callback() {
				public void onCompletion(RecordMetadata recordMetadata, Exception e) {
					// executes every time a record is successfully sent
					// or an exception is thrown

					if (e == null) {
						logger.info("Received new metadata. \n" + "Topic: " + recordMetadata.topic() + "\n"
								+ "Partition: " + recordMetadata.partition() + "\n" + "Offset: "
								+ recordMetadata.offset() + "\n" + "Timestamp: " + recordMetadata.timestamp());
					} else {
						logger.error("Error while producing", e);
					}

				}
			}).get();// block the .send() to make it synchronous - don't do this in production!
		}

		// flush data
		producer.flush();

		// flush and close
		producer.close();

	}

}
