package com.group.genshinProg.model.entity;

import com.group.genshinProg.model.enums.RangCode;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "pray_result")
public class PrayResult {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rang")
    private String rang;


    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user_id")
    private Long user_id;

    public PrayResult(String name, String rang, Long user_id) {
        this.name = name;
        this.rang = rang;
        this.date = LocalDate.now();
        this.user_id = user_id;
    }

    public PrayResult(String name, String rang) {
        this.name = name;
        this.rang = rang;
        this.date = LocalDate.now();
        this.user_id = 1L;
    }


    public PrayResult(String name) {
        this.name = name;
        this.rang = RangCode.THREE_STAR.toString();
        this.date = LocalDate.now();
        this.user_id = 1L;
    }

    public PrayResult() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RangCode getRang() {
        return RangCode.getRangCodeByString(rang);
    }

    public void setRang(RangCode rang) {
        this.rang = rang.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setUserId(Long user_id) {this.user_id = user_id;}

    public Long getUserId() {return user_id;}

    @Override
    public String toString() {
        return "PrayResult{" +
                "id=" + id +
                ", name = '" + name + '\'' +
                ", rang = " + rang + '\'' +
                ", date = '" + date  + '\'' +
                ", user id = '" + user_id  + '\'' +
                '}';
    }
}
