package kafka.kh.gov.kafka_topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kafka.kh.gov.kafka_topic.services.KafkaProducerService;

@Component
public class KafkaHelper implements CommandLineRunner{

    /**
     * @implNote Initail send topic 
     * 
     */
    @Autowired
    private KafkaProducerService kafkaProducerService;
    private final String topic = "auth"; //kafka-topic25
    private final String key = "data"; 
    private final String message = "Hello TSC";

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Started RUN Component %s%n"+topic);
        kafkaProducerService.sendMessage(topic, key, message); 
    }
}
