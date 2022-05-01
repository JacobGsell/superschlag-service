package com.jacob.superschlag.controller;

import com.jacob.superschlag.access.AvatarDao;
import com.jacob.superschlag.entity.Avatar;
import com.jacob.superschlag.entity.Job;
import com.jacob.superschlag.mapping.AvatarMapper;
import com.jacob.superschlag.mapping.JobMapper;
import com.jacob.superschlag.service.AvatarService;
import com.jacob.superschlag.service.JobService;
import com.jacob.superschlag.transfer.AvatarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/avatar")
public class AvatarController {

    private final AvatarService avatarService;

    @Autowired
    public AvatarController(AvatarService avatarService, JobService jobService) {
        this.avatarService = avatarService;
    }

    @GetMapping(value = "/{avatarId}")
    public @ResponseBody
    AvatarDto getAvatarById(@PathVariable String avatarId) {
        AvatarDto avatarDto = avatarService.getAvatarDtoById(avatarId);
        return avatarDto;
    }

    @PostMapping
    public void postAvatar(@RequestBody AvatarDao avatarDao, HttpServletResponse response) throws Exception {
        avatarService.handleNewAvatar(avatarDao);

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @DeleteMapping(value = "/{avatarId}")
    public void deleteAvatarById(@PathVariable String avatarId, HttpServletResponse response) {
        avatarService.deleteAvatarById(avatarId);

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
