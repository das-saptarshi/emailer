package com.saptarshi.das.core.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Accessors(chain = true)
public class PaginationDTO<T> {
    private Collection<T> records;
    private Long totalRecords;
}
