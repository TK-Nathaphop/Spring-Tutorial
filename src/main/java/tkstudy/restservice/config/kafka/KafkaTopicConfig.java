package tkstudy.restservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  private final String kafkaAddress = "localhost:29092";

  @Bean
  public NewTopic createStudyTopic() {
    return TopicBuilder.name("study-topic")
        .replicas(10)
        .partitions(1)
        .build();
  }
}