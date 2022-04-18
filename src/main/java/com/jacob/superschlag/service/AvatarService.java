package com.jacob.superschlag.service;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.ItemType;
import com.jacob.superschlag.exception.InvalidOwnedItemListException;
import com.jacob.superschlag.mapping.AvatarMapper;
import com.jacob.superschlag.transfer.AvatarDto;
import com.jacob.superschlag.transfer.OwnedItemDto;
import com.jacob.superschlag.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AvatarService {
    private final AvatarRepository avatarRepository;

    @Autowired
    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public Avatar findAvatarById(long id) {
        Optional<Avatar> avatarOptional = avatarRepository.findById(id);

        if (avatarOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return avatarOptional.get();
    }

    public void handleNewAvatar(AvatarDto avatarDto) throws Exception {
        List<OwnedItemDto> equippedItems = avatarDto.getOwnedItemDtoList()
                .stream()
                .filter(OwnedItemDto::isEquipped)
                .collect(Collectors.toList());

        if (!hasDistinctItemTypes(equippedItems)) {
            throw new InvalidOwnedItemListException("Only one equipped item per item type allowed!");
        }

        if (equippedItems.size() < 3) {
            throw new InvalidOwnedItemListException("More than 3 items are equipped!");
        }

            Avatar avatar = AvatarMapper.toAvatar(avatarDto);

        avatarRepository.save(avatar);
    }

    boolean hasDistinctItemTypes(List<OwnedItemDto> equippedItemList) {
        Set<ItemType> distinctItemTypesSet = new HashSet<>();

        for (OwnedItemDto ownedItemDto :
                equippedItemList) {
            // Type already in set
            if (!distinctItemTypesSet.add(ownedItemDto.getItemDto().getItemType())) {
                return false;
            }
        }

        return true;
    }
}
