package com.pen.roadmap.business.domain;

import com.pen.roadmap.repository.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
  private Integer id;
  private String username;
  private String email;
  private int rank;
  private List<Role> roles;
}
