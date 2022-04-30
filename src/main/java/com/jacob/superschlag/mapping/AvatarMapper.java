package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.transfer.AvatarDto;
import com.jacob.superschlag.transfer.OwnedItemDto;
import com.jacob.superschlag.transfer.StatsDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AvatarMapper {

    public static Avatar toAvatar(AvatarDto avatarDto) throws Exception {
        return Avatar.builder()
                .id(UUID.randomUUID().toString())
                .name(avatarDto.getName())
                .job(JobMapper.toJob(avatarDto.getJobDto()))
                .ownedItemList(getOwnedItemList(avatarDto))
                .build();
    }

    public static AvatarDto toDto(Avatar avatar) {
        return AvatarDto.builder()
                .name(avatar.getName())
                .jobDto(JobMapper.toDto(avatar.getJob()))
                .totalStats(getTotalStats(avatar))
                .ownedItemDtoList(getOwnedItemDtoList(avatar))
                .build();
    }

    static StatsDto getTotalStats(Avatar avatar) {
        StatsDto totalStats;

        List<Stats> allStats = getAllStats(avatar);

        totalStats = allStats.stream()
                .map(StatsMapper::toDto)
                .reduce(new StatsDto(), (base, element) -> {
                    base.setAttack(base.getAttack() + element.getAttack());
                    base.setDefense(base.getDefense() + element.getDefense());
                    base.setEvasion(base.getEvasion() + element.getEvasion());
                    base.setLuck(base.getLuck() + element.getLuck());
                    base.setHealth(base.getHealth() + element.getHealth());
                    return base;
                });

        return totalStats;
    }

    static List<Stats> getAllStats(Avatar avatar) {
        List<Stats> allStats;

        allStats = avatar.getOwnedItemList()
                .stream()
                .filter(OwnedItem::isEquipped)
                .map(ownedItem -> ownedItem.getItem().getStats())
                .collect(Collectors.toList());

        allStats.add(avatar.getJob().getStats());

        return allStats;
    }

    static List<OwnedItemDto> getOwnedItemDtoList(Avatar avatar) {
        return avatar.getOwnedItemList()
                .stream()
                .map(OwnedItemMapper::toDto)
                .collect(Collectors.toList());
    }

    static List<OwnedItem> getOwnedItemList(AvatarDto avatarDto) throws Exception {
        if (avatarDto.getOwnedItemDtoList().isEmpty()) {
            throw new Exception();
        }

        return avatarDto.getOwnedItemDtoList()
                .stream()
                .map(OwnedItemMapper::toOwnedItem)
                .collect(Collectors.toList());
    }
}
