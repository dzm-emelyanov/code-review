package ru.dc.review.cache;

import org.springframework.stereotype.Component;

@Component
public interface Cache<K, T> {

  T get(K id);

  long liveTimeMS(K id);

  void set(K id, T value);

}
