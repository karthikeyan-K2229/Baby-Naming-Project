package com.project.babynaming.entity;
import javax.persistence.*;

@Entity
@Table
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String rating;
    private String feedback;

    public FeedBack(int id, String name, String rating, String feedback) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.feedback = feedback;
    }

    public FeedBack() {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
