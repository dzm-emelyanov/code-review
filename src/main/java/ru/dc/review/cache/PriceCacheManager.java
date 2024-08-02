package ru.dc.review.cache;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import ru.dc.review.client.PriceClient;

@Component
@RequiredArgsConstructor
public class PriceCacheManager {

  private final PriceClient priceClient;
  private final PriceCacheFactory cacheFactory;
  private Cache<Long, BigDecimal> priceCache;

  @PostConstruct
  void init() {
    priceCache = cacheFactory.createEmptyCache();
  }

  public BigDecimal getProductPrice(Long productId) {
    if (recalculate(productId)) {
      val price = priceClient.calculatePrice(productId);
      priceCache.set(productId, price);
    }
    return priceCache.get(productId);
  }

  protected boolean recalculate(Long productId) {
    boolean result = true;

    val live = priceCache.liveTimeMS(productId);
    if (live != -1 && live < 300_000) {
      result = false;
    }

    return result;
  }

}
