package com.erosnox.imobli.infrastructure.services;

import com.erosnox.imobli.core.shared.contracts.TempStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService implements TempStorageService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void save(String key, String value, long expirationTimeInSeconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(expirationTimeInSeconds));
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
