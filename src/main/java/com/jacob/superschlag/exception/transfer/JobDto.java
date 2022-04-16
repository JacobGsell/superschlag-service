package com.jacob.superschlag.exception.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class JobDto {
    private String name;
    private StatsDto statsDto;
}
