package com.jacob.superschlag.exception.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarDto {
    private String name;
    private JobDto jobDto;
    private StatsDto totalStats;
    private List<OwnedItemDto> ownedItemDtoList;
}
