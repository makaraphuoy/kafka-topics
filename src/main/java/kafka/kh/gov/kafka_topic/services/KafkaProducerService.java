package kafka.kh.gov.kafka_topic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public <T> void sendMessage(String topic, String key, T message) {
        kafkaTemplate.send(topic, key, message);
    }
}
