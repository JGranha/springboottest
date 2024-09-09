package dark.shadowland.petproject.databasedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AppRestTestJacksonDTO (String name){};
