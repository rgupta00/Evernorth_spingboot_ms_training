package com.secapp.service;

import com.secapp.repo.UserEntity;
import com.secapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUserEntity(UserEntity userEntity) {
        userRepo.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }
}
