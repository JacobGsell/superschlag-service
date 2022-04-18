package com.jacob.superschlag.transfer;

import com.sun.istack.NotNull;
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
    @NotNull
    private String name;

    @NotNull
    private JobDto jobDto;

    private StatsDto totalStats;

    private List<OwnedItemDto> ownedItemDtoList;
}
