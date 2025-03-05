package kafka.kh.gov.kafka_topic.config;

import java.util.Objects;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KafkaConfig {
  private final String kafkaUri = Objects.requireNonNullElse(System.getenv("KAFKA_URI"), "localhost:9092");
  private final String kafkaGroupId = Objects.requireNonNullElse(System.getenv("KAFKA_GROUP_ID"), "tsc-2025-kfk-group");
}
