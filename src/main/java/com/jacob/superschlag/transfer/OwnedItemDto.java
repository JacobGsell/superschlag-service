package com.jacob.superschlag.transfer;

import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnedItemDto {
    private ItemDto itemDto;

    private boolean isEquipped;
}
