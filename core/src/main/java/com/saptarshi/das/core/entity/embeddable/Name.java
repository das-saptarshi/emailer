package com.saptarshi.das.core.entity.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Embeddable
@Accessors(chain = true)
public class Name {
    private String firstName;
    private String lastName;

    @Transient
    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
