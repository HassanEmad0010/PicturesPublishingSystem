package com.hassanemad.picturespublishing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEntity {
private String userEmail;
private String password;
private boolean isLoggedIn;
}
