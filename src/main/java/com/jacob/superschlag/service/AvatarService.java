package com.jacob.superschlag.service;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.exception.transfer.AvatarDto;
import com.jacob.superschlag.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

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

    public void handleNewAvatar(AvatarDto avatarDto) {
        Avatar avatar = new Avatar();
// todo: mappen!
        avatarRepository.save(avatar);
    }
}
