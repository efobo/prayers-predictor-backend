package com.group.genshinProg.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "password")
    private String password;

    public User(String name) {
        this.name = name;
    }

    public User(){}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
}
