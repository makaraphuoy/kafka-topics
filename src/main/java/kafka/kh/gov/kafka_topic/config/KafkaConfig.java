package kafka.kh.gov.kafka_topic.config;

import org.springframework.context.annotation.Configuration;

// import java.util.Objects;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Configuration
public class KafkaConfig {
  private final String kafkaUri = "localhost:9092";//Objects.requireNonNullElse(System.getenv("KAFKA_URI"), "localhost:9092");
  private final String kafkaGroupId = "aba2424";//Objects.requireNonNullElse(System.getenv("KAFKA_GROUP_ID"), "tsc-2025-kfk-group");
}
