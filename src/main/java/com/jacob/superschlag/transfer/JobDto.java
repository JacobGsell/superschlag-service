package com.jacob.superschlag.transfer;

import com.sun.istack.NotNull;
import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private String id;

    @NotNull
    private String name;

    private StatsDto statsDto;
}
