package com.hassanemad.picturespublishing.db;

import com.hassanemad.picturespublishing.entities.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Deprecated
@Component
public class AdminDb {

    public List<Admin> adminEntities;
    public AdminDb() {
        adminEntities = new ArrayList<>();
    }
}
