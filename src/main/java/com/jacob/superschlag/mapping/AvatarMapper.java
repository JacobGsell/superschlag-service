package com.jacob.superschlag.mapping;

import com.jacob.superschlag.access.AvatarDao;
import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.service.JobService;
import com.jacob.superschlag.transfer.AvatarDto;
import com.jacob.superschlag.transfer.OwnedItemDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AvatarMapper {
    public static Avatar toAvatar(AvatarDao avatarDao) throws Exception {
        return Avatar.builder()
                .id(UUID.randomUUID().toString())
                .name(avatarDao.getName())
                .jobId(avatarDao.getJobId())
                .ownedItemList(getOwnedItemList(avatarDao))
                .build();
    }

    public static Avatar toAvatar(AvatarDto avatarDto) throws Exception {
        return Avatar.builder()
                .id(avatarDto.getId())
                .name(avatarDto.getName())
                .jobId(avatarDto.getJobDto().getId())
                .ownedItemList(getOwnedItemList(avatarDto))
                .build();
    }

    public static AvatarDto toDto(Avatar avatar) {
//        Job job = jobService.findJobById(avatar.getJobId());

        return AvatarDto.builder()
                .id(avatar.getId())
//                .jobDto(JobMapper.toDto(job))
                .name(avatar.getName())
                .ownedItemDtoList(getOwnedItemDtoList(avatar))
                .build();
    }


    static List<OwnedItemDto> getOwnedItemDtoList(Avatar avatar) {
        return avatar.getOwnedItemList()
                .stream()
                .map(OwnedItemMapper::toDto)
                .collect(Collectors.toList());
    }

    static List<OwnedItem> getOwnedItemList(AvatarDto avatarDto) throws Exception {
        return avatarDto.getOwnedItemDtoList()
                .stream()
                .map(OwnedItemMapper::toOwnedItem)
                .collect(Collectors.toList());
    }

    static List<OwnedItem> getOwnedItemList(AvatarDao avatarDao) throws Exception {
        return avatarDao.getOwnedItemDaoList()
                .stream()
                .map(OwnedItemMapper::toOwnedItem)
                .collect(Collectors.toList());
    }
}
