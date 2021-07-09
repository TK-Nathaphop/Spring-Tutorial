package tkstudy.restservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {

  @Autowired
  private final KafkaTemplate<String, String> kafkaTemplate;

  public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void produce(String message) {
    ListenableFuture<SendResult<String, String>> response = kafkaTemplate
        .send("study-topic", message);
    ListenableFutureCallback<SendResult<String, String>> callBack =
        new ListenableFutureCallback<SendResult<String, String>>() {
          @Override
          public void onFailure(Throwable ex) {
            System.out
                .println("Unable to send message [" + message + "] due to:" + ex.getMessage());
          }

          @Override
          public void onSuccess(SendResult<String, String> result) {
            System.out.println("Sending message [" + message + "] successfully");
          }
        };
    response.addCallback(callBack);
  }
}
