package com.maslov.securityhomework.service.data.provider;

import com.maslov.securityhomework.domain.Author;
import com.maslov.securityhomework.domain.User;
import com.maslov.securityhomework.model.UserDo;
import com.maslov.securityhomework.repository.UserDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDataProvider {
    private final UserDetailsRepo userRepo;

    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    public User createUser(UserDo userDo) {
        User user = new User();
        user.setName(userDo.getName());
        user.setPassword(userDo.getPassword());
        user.setActive(userDo.isActive());
        user.setRoles(userDo.getRoles());
        return userRepo.save(user);
    }
}
