package com.pen.roadmap.business.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AuthorDto {
    private long id;

    @NotNull
    @Size(max = 255)
    private String username;

    @Email
    private String email;

    private int rank = 0;

    @NotNull
    @Size(max = 255)
    private String password;
}
