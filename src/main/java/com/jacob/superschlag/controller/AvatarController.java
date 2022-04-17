package com.jacob.superschlag.controller;

import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.exception.mapping.AvatarMapper;
import com.jacob.superschlag.exception.transfer.AvatarDto;
import com.jacob.superschlag.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/avatar")
public class AvatarController {

    private final AvatarService avatarService;

    @Autowired
    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping(value = "/{avatarId}")
    public @ResponseBody
    AvatarDto getAvatarById(@PathVariable long avatarId) {
        Avatar avatar = avatarService.findAvatarById(avatarId);
        AvatarDto avatarDto = AvatarMapper.toDto(avatar);

        return avatarDto;
    }

    @PostMapping
    public void postAvatar(@RequestBody AvatarDto avatarDto, HttpServletResponse response) throws Exception {
        System.out.println(avatarDto);
        avatarService.handleNewAvatar(avatarDto);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }
}
