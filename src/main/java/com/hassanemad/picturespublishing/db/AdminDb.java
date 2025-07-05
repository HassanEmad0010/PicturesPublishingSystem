package com.hassanemad.picturespublishing.db;

import com.hassanemad.picturespublishing.entities.AdminEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDb {

    public List<AdminEntity> adminEntities;
    public AdminDb() {
        adminEntities = new ArrayList<>();
    }
}
