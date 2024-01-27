package com.saptarshi.das.core.entity;

import com.saptarshi.das.core.entity.embeddable.Name;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "APP_USER")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private Name name;
    private String email;
    private String password;
}
