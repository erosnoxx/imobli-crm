package com.erosnox.imobli.core.shared.contracts;

public interface TempStorageService {
    void save(String key, String value, long expirationTimeInSeconds);

    String get(String key);

    void delete(String key);
}
