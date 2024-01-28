package com.saptarshi.das.core.entity;

import com.saptarshi.das.core.entity.embeddable.Name;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "APP_USER", indexes = @Index(columnList = "email"))
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Column(name = "user_name")
    private Name name;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_password")
    private String password;
}
