package com.example.cgf;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaPoller {
    private KafkaConsumer<String, String> consumer;

    public KafkaPoller(Properties kafkaProps, String topic) {
        this.consumer = new KafkaConsumer<>(kafkaProps);
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    public String pollMessage() {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
        for (ConsumerRecord<String, String> record : records) {
            return record.value();
        }
        return null;
    }

    public void close() {
        consumer.close();
    }
}
