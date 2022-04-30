package com.jacob.superschlag.service;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.ItemType;
import com.jacob.superschlag.exception.InvalidOwnedItemListException;
import com.jacob.superschlag.repository.AvatarRepository;
import com.jacob.superschlag.transfer.AvatarDto;
import com.jacob.superschlag.transfer.ItemDto;
import com.jacob.superschlag.transfer.OwnedItemDto;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AvatarServiceTest {

    @Mock
    AvatarRepository avatarRepositoryMock;

    @InjectMocks
    AvatarService sut;

    @BeforeEach
    public void setUp() {
        avatarRepositoryMock = Mockito.mock(AvatarRepository.class);
    }

    @Test
    public void findAvatarById_should_get_AvatarOptional_on_existing_id() {
        // Arrange
        String avatarId = UUID.randomUUID().toString();
        Avatar expected = new Avatar();
        Optional<Avatar> expectedOptional = Optional.of(expected);

        when(avatarRepositoryMock.findById(avatarId)).thenReturn(expectedOptional);

        // Act
        Avatar actual = sut.findAvatarById(avatarId);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void findAvatarById_should_throw_EntityNotFoundException_on_empty_AvatarOptional() {
        // Arrange
        String avatarId = UUID.randomUUID().toString();
        Optional<Avatar> actual = Optional.empty();

        when(avatarRepositoryMock.findById(avatarId)).thenReturn(actual);

        // Act and Assert
        assertThrows(EntityNotFoundException.class, () -> sut.findAvatarById(avatarId));
    }

    @Test
    public void handleNewAvatar_should_throw_InvalidOwnedItemListException_on_indistinct_weaponTypes() {
        // Arrange
        ItemDto itemDto1 = ItemDto.builder()
                .itemType(ItemType.WEAPON)
                .build();

        ItemDto itemDto2 = ItemDto.builder()
                .itemType(ItemType.ARMOR)
                .build();

        ItemDto itemDto3 = ItemDto.builder()
                .itemType(ItemType.WEAPON)
                .build();

        OwnedItemDto ownedItemDto1 = OwnedItemDto.builder()
                .itemDto(itemDto1)
                .isEquipped(true)
                .build();

        OwnedItemDto ownedItemDto2 = OwnedItemDto.builder()
                .itemDto(itemDto2)
                .isEquipped(true)
                .build();

        OwnedItemDto ownedItemDto3 = OwnedItemDto.builder()
                .itemDto(itemDto3)
                .isEquipped(true)
                .build();

        List<OwnedItemDto> ownedItemDtoList = List.of(ownedItemDto1, ownedItemDto2, ownedItemDto3);

        AvatarDto avatarDto = AvatarDto.builder()
                .ownedItemDtoList(ownedItemDtoList)
                .build();

        // Act and Assert
        assertThrows(InvalidOwnedItemListException.class, () -> sut.handleNewAvatar(avatarDto));
    }

    @Test
    public void handleNewAvatar_should_throw_InvalidOwnedItemListException_on_too_long_OwnedItemList_length() {
        // Arrange
        AvatarDto avatarDto = AvatarDto.builder()
                .ownedItemDtoList(
                        List.of(
                                new OwnedItemDto(),
                                new OwnedItemDto(),
                                new OwnedItemDto(),
                                new OwnedItemDto()
                        )
                )
                .build();

        // Act and ASsert
        assertThrows(InvalidOwnedItemListException.class, () -> sut.handleNewAvatar(avatarDto));
    }
}