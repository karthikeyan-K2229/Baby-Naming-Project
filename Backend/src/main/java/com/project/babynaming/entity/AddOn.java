package com.project.babynaming.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;

@Entity
@Table(name="add_on")
public class AddOn {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String price;
    @Column
    private String image;

    public AddOn() {
    }


    @Builder(builderMethodName = "builder")
    public static AddOn Addon(long id, String name, String price, String image) {
        return new AddOn(id,name,price,image);
    }






    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    protected AddOn(long id, String name, String price, String image) {}

    public AddOn(String name, String price, String image) {

        this.name = name;
        this.price = price;
        this.image=image;

    }

    public String toString() {
        return String.format("id=%d,name=%s, price=%s, image=%s",
                id, name, price,image);
    }
}


