package com.erosnox.imobli.infrastructure.persistence.entities.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@MappedSuperclass @Getter
public abstract class BaseJpaEntity<T> {
    @Setter @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
