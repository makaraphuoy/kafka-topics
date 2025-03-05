package kafka.kh.gov.kafka_topic.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "kafka-topic23", groupId = "tsc-2025-kfk-group")
    public void listen(ConsumerRecord<String, String> record) {
      String constNString = "generate-token";
        if(record.key().equals(constNString)){
          System.out.printf("Calling Authorization Service %n");
        }
        System.out.printf("Consumed record with key %s and value %s%n", record.key(), record.value());
    }

    @KafkaListener(topics = "kafka-topic", groupId = "tsc-2025-kfk-group")
    public void listenJson(ConsumerRecord<String, String> record) {
      System.out.printf("Consumed JSON record with key %s and value %s%n", record.key(), record.value());
    }
}
