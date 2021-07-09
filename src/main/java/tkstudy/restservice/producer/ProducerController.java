package tkstudy.restservice.producer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/producer")
public class ProducerController {

  final ProducerService producerService;

  public ProducerController(ProducerService producerService) {
    this.producerService = producerService;
  }

  @GetMapping()
  public @ResponseBody
  String produceMessage(@RequestParam String message) {
    this.producerService.produce(message);
    return "Done";
  }
}
