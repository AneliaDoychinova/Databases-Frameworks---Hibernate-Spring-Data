package com.user.system.usersystem.services.impl;

import com.user.system.usersystem.repositories.CountryRepo;
import com.user.system.usersystem.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryServiceImpl implements CountryService {
    private CountryRepo repo;

    @Autowired
    public CountryServiceImpl(CountryRepo repo) {
        this.repo = repo;
    }
}
