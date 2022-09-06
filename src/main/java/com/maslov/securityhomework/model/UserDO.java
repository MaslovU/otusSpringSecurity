package com.maslov.securityhomework.model;

import com.maslov.securityhomework.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
@Builder
public class UserDO {
    private String name;
    private String password;
    private boolean active;
    private Set<Role> roles;
}
