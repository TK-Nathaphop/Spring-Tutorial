package tkstudy.restservice.cacheManager;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping(path = "/cache")
public class CacheController {

  @PostMapping()
  @CacheEvict(value = "user", key = "#id")
  public @ResponseBody
  String removeCache(@RequestParam Integer id) {
    return "Remove cache";
  }
}
