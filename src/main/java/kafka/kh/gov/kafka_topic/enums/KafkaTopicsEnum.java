package kafka.kh.gov.kafka_topic.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KafkaTopicsEnum {
  USER_REGISTRATION("user-registration"),
  ORDER_PLACED("order-placed"),
  PAYMENT_PROCESSED("payment-processed"),
  AUTH_GENERATE_ACCESS_TOKEN("auth_generate_access_token"),
  INVENTORY_UPDATED("inventory-updated");

  private final String topicName;

}
