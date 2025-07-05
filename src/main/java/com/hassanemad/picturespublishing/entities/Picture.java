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
@Table(name = "pictures")
public class Picture {

    @Id
    private String id;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "url")
    private String url;
    @Column(name = "status")
    private String picStatus;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
}
