package com.saptarshi.das.core.entity.listener;

import com.saptarshi.das.core.entity.BaseEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class EntityListener {

    @PrePersist
    public void prePersist(final BaseEntity entity) {
        entity.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
    }

    @PreUpdate
    public void preUpdate(final BaseEntity entity) {
        entity.setUpdatedAt(OffsetDateTime.now(ZoneOffset.UTC));
    }
}
