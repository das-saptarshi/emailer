package com.saptarshi.das.core.entity;

import com.saptarshi.das.core.entity.listener.EntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners({EntityListener.class})
@Accessors(chain = true)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;
}
