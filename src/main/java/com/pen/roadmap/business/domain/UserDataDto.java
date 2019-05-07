package com.pen.roadmap.business.domain;

import com.pen.roadmap.repository.entity.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserDataDto {
    @NotNull
    @Size(max = 255)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(max = 255)
    private String password;

    private  List<Role> roles;
}
