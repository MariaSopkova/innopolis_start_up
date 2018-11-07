package ru.innopolis.stc12.pojo;

import java.util.Date;

public class Exibition {
    private int id;
    private String name;
    private int city;
    private Date date;

    public Exibition(int id, String name, int city, Date date) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
