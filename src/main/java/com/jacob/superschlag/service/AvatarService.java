package com.jacob.superschlag.service;

import com.jacob.superschlag.access.AvatarDao;
import com.jacob.superschlag.access.OwnedItemDao;
import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.ItemType;
import com.jacob.superschlag.exception.InvalidOwnedItemListException;
import com.jacob.superschlag.mapping.AvatarMapper;
import com.jacob.superschlag.repository.AvatarRepository;
import com.jacob.superschlag.transfer.OwnedItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AvatarService {
    private final AvatarRepository avatarRepository;

    @Autowired
    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public Avatar findAvatarById(String id) {
        Optional<Avatar> avatarOptional = avatarRepository.findById(id);

        if (avatarOptional.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return avatarOptional.get();
    }

    public void handleNewAvatar(AvatarDao avatarDao) throws Exception {
        List<OwnedItemDao> equippedItems = avatarDao.getOwnedItemDaoList()
                .stream()
                .filter(OwnedItemDao::isEquipped)
                .collect(Collectors.toList());

        Avatar avatar = AvatarMapper.toAvatar(avatarDao);

        avatarRepository.save(avatar);
    }

    public void deleteAvatarById(String id) {
        avatarRepository.deleteById(id);
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
