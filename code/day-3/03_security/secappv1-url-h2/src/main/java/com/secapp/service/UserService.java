package com.secapp.service;

import com.secapp.repo.UserEntity;

import java.util.List;

public interface UserService {
    public UserEntity findByUsername(String username);
    public void addUserEntity(UserEntity userEntity);
    public List<UserEntity> findAll();
}