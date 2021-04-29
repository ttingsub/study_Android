package com.example.my31_recyclerview3;

import java.io.Serializable;

public class SoccerDto implements Serializable {
    String name, team, site;
    int age, resId;



    public SoccerDto(String name, String team, String site, int resId) {
        this.name = name;
        this.team = team;
        this.site = site;
        this.resId = resId;
    }

    public SoccerDto(String name, String team, String site, int age, int resId) {
        this.name = name;
        this.team = team;
        this.site = site;
        this.age = age;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
