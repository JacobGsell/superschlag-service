package com.jacob.superschlag.mapping;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.entity.OwnedItem;
import com.jacob.superschlag.entity.Stats;
import com.jacob.superschlag.service.JobService;
import com.jacob.superschlag.transfer.AvatarDto;
import com.jacob.superschlag.transfer.OwnedItemDto;
import com.jacob.superschlag.transfer.StatsDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AvatarMapper {

    private static JobService jobService;

    @Autowired
    public AvatarMapper(JobService jobService) {
        AvatarMapper.jobService = jobService;
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
        Job job = jobService.findJobById(avatar.getJobId());

        return AvatarDto.builder()
                .id(avatar.getId())
                .jobDto(JobMapper.toDto(job))
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
        if (avatarDto.getOwnedItemDtoList().isEmpty()) {
            throw new Exception();
        }

        return avatarDto.getOwnedItemDtoList()
                .stream()
                .map(OwnedItemMapper::toOwnedItem)
                .collect(Collectors.toList());
    }
}
