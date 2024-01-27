package com.saptarshi.das.core.entity;

import com.saptarshi.das.core.entity.embeddable.Name;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "APP_USER")
public class User {
    private Name name;
    private String email;
    private String password;
}
