package ru.dc.review.cache;

public abstract class CacheFactory<K, T> {

  abstract Cache<K, T> createEmptyCache();

}
