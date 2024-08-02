package ru.dc.review.client;

import java.util.List;
import org.springframework.stereotype.Component;
import ru.dc.review.dto.PopularityDto;

//f.e. feign
@Component
public interface IntegrationClient {

  List<PopularityDto> getPopularities();

  PopularityDto getPopularityById(Long id);

}
