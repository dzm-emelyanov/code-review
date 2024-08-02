package ru.dc.review.client;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public interface PriceClient {

  BigDecimal calculatePrice(Long productId);
}
