package com.kaicheng.springbootkafkademo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerDemoWithCallback {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);

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
			ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", "hello world" + Integer.toString(i));

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
			});
		}

		// flush data
		producer.flush();

		// flush and close
		producer.close();

	}

}
