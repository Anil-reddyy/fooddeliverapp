package com.food_deliver.restaurant_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Getter
@Setter
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String name;
    private String location;
    private String description;
    private boolean Status=true;
    private String timing;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image; // Store image bytes directly

}
