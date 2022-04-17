package com.jacob.superschlag.exception.transfer;

import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private String name;
    private StatsDto statsDto;
}
