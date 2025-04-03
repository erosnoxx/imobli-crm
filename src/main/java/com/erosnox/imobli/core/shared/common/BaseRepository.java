package com.erosnox.imobli.core.shared.common;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, I> {
    T save(T entity);

    T update(T entity);

    void deleteById(I id);

    Optional<T> getById(I id);

    boolean existsById(I id);

    List<T> getAll();
}
