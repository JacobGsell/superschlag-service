package com.jacob.superschlag.exception.transfer;

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
