package com.hassanemad.picturespublishing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "email")
    private String userEmail;
    @Column(name = "password")
    private String password;
    @Column(name="is_logged_in")
    private boolean isLoggedIn;
}
