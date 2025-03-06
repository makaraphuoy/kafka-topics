package kafka.kh.gov.kafka_topic.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import kafka.kh.gov.kafka_topic.enums.KafkaTopicsEnum;

@Service
public class KafkaConsumerService {

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaConsumerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "kafka-topic23", groupId = "tsc-2025-kfk-group")
    public void listen(ConsumerRecord<String, String> record) {
      try{
        String constNString = "generate-token";
        if(record.key().equals(constNString)){
          System.out.printf("Calling Authorization Service %n");
        }
        if (record.value().contains("error")) {
          throw new RuntimeException("Processing error");
        }
        System.out.printf("Consumed record with key %s and value %s%n", record.key(), record.value());
      }catch(Exception e){
        kafkaTemplate.send("dlq-topic", record.key(), record.value());
      }
    }

    @KafkaListener(topics = "kafka-topic", groupId = "tsc-2025-kfk-group")
    public void listenJson(ConsumerRecord<String, String> record) {
      try{
        System.out.printf("Consumed JSON record with key %s and value %s%n", record.key(), record.value());
      }catch(Exception e){
        kafkaTemplate.send("dlq-topic", record.key(), record.value());
      }
    }

    /**
     * 
     * @implNote Multi-Consumers Errors Handling
     * @implNote Retry 3 times
     * @implNote Delay time between retry 2 seconds
     * 
     */
    @Retryable(
      value = { Exception.class },
      maxAttempts = 3,
      backoff = @Backoff(delay = 2000)
    )
    @KafkaListener(topics = "auth-token", groupId = "tsc-2025")
    public void MultiListen(ConsumerRecord<String, String> record) {
        System.out.println("Consumed message: " + record.value()+ KafkaTopicsEnum.AUTH_GENERATE_ACCESS_TOKEN);
        if (record.value().contains("error")) {
            throw new RuntimeException("Processing error");
        }
    }
}
