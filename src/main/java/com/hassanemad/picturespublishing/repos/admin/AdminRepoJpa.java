package com.hassanemad.picturespublishing.repos.admin;

import com.hassanemad.picturespublishing.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepoJpa extends JpaRepository<Admin, String> {

    List<Admin> findByUsernameAndPassword(String username, String password);
}
