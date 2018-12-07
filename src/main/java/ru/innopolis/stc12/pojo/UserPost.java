package ru.innopolis.stc12.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_posts")
public class UserPost implements Serializable {
    private int id;
    private Date startDate;
    private Date endDate;
    private String title;
    private String body;
    private String style;
    private User user;

    public UserPost() {
    }

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    public int getId() {
        return id;
    }

    public UserPost setId(int id) {
        this.id = id;
        return this;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public UserPost setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public UserPost setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Column(name = "title", length = 256)
    public String getTitle() {
        return title;
    }

    public UserPost setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(name = "body", length = 4048)
    public String getBody() {
        return body;
    }

    public UserPost setBody(String body) {
        this.body = body;
        return this;
    }

    @Column(name = "style", length = 256)
    public String getStyle() {
        return style;
    }

    public UserPost setStyle(String style) {
        this.style = style;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public UserPost setUser(User user) {
        this.user = user;
        return this;
    }
}
