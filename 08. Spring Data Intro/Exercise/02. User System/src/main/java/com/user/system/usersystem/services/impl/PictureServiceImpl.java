package com.user.system.usersystem.services.impl;

import com.user.system.usersystem.repositories.PictureRepo;
import com.user.system.usersystem.services.interfaces.PictureService;
import org.springframework.beans.factory.annotation.Autowired;

public class PictureServiceImpl implements PictureService {
    private PictureRepo repo;

    @Autowired
    public PictureServiceImpl(PictureRepo repo) {
        this.repo = repo;
    }
}
