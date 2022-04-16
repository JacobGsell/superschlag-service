package com.jacob.superschlag.exception.transfer;

import com.jacob.superschlag.entity.Stats;
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
    private Stats totalStats;
    private List<OwnedItemDto> ownedItemDtoList;
}
