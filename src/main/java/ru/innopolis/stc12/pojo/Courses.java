package ru.innopolis.stc12.pojo;

import java.util.Date;

public class Courses {
    private int id;
    private String name;
    private int city;
    private Date startDate;
    private Date endDate;
    private int handlerId;
    private int cost;

    public Courses(int id, String name, int city, Date startDate, Date endDate, int handlerId, int cost) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.handlerId = handlerId;
        this.cost = cost;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
