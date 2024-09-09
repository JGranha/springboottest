package dark.shadowland.petproject.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dark.shadowland.petproject.databasedto.AppRestTestGSonDTO;
import dark.shadowland.petproject.databasedto.AppRestTestPlainDTO;

@RestController
public class AppRestController {
  @GetMapping("/justString")
  String justOne() {
    return "Was good";
  }

  @GetMapping("/justGson")
  String justTwo() {
    AppRestTestGSonDTO appRestTestDTO = new AppRestTestGSonDTO("magic");

    return new Gson().toJson(appRestTestDTO);
  }

  @GetMapping("/justPlain")
  String justThree() {
    AppRestTestPlainDTO appRestTestDTO = new AppRestTestPlainDTO("magic");

    return appRestTestDTO.toString();
  }

  @GetMapping("/justJackson")
  String justFour() {
    try {
      AppRestTestPlainDTO appRestTestDTO = new AppRestTestPlainDTO("magic");

      // Does not work as intended
      /*
      AppRestTestJacksonDTO appRestTestDTO = new AppRestTestJacksonDTO("magic");

      return appRestTestDTO.toString();*/

      return new ObjectMapper().writeValueAsString(appRestTestDTO);
    } catch (JsonProcessingException e) {
      return "borcht";
    }
  }
}
