package tkstudy.restservice.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@KafkaListener(id = "consumer-id", topics = "study-topic")
@Component
public class Consumer {

  @KafkaHandler
  public void listen(String message) {
    System.out.println("Consumer received message:" + message);
  }

  @KafkaHandler(isDefault = true)
  public void listenDefault(String message) {
    System.out.println("Default consumer received message:" + message);
  }
}
