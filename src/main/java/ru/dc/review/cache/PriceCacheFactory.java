package ru.dc.review.cache;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class PriceCacheFactory extends CacheFactory<Long, BigDecimal> {

  @Override
  Cache<Long, BigDecimal> createEmptyCache() {
    return null;
  }
}
