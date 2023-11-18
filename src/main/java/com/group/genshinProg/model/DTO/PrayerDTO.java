package com.group.genshinProg.model.DTO;

import lombok.Data;

import java.io.Serializable;


public class PrayerDTO implements Serializable {
    String name;
    String rang;

    public PrayerDTO(String name, String rang) {
        this.name = name;
        this.rang = rang;
    }

    public void setName(String name) {this.name = name;}
    public void setRang(String rang) {this.rang = rang;}

    public String getName() {return name;}
    public String getRang() {return rang;}
}
