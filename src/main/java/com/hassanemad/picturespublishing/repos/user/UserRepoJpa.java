package com.hassanemad.picturespublishing.repos.user;

import com.hassanemad.picturespublishing.dto.UserDto;
import com.hassanemad.picturespublishing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepoJpa extends JpaRepository<User, String> {
    User findByUserEmail(String email);
}
