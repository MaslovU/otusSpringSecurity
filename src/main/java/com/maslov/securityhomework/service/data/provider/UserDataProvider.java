package com.maslov.securityhomework.service.data.provider;

import com.maslov.securityhomework.domain.MyUser;
import com.maslov.securityhomework.model.UserDo;
import com.maslov.securityhomework.repository.UserDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDataProvider {
    private final UserDetailsRepo userRepo;

    public MyUser findByName(String name) {
        return userRepo.findByName(name);
    }

    public MyUser createUser(UserDo userDo) {
        MyUser user = new MyUser();
        user.setName(userDo.getName());
        user.setPassword(userDo.getPassword());
        user.setActive(userDo.isActive());
        user.setRoles(userDo.getRoles());
        return userRepo.save(user);
    }
}
