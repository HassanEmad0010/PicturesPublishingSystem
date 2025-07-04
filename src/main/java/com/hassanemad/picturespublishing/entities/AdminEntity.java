package com.hassanemad.picturespublishing.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@AllArgsConstructor
public class AdminEntity {

    private String username;
    private String password;
    private boolean isLoggedIn;




}
