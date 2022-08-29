package com.project.babynaming.entity;

import javax.persistence.*;

@Entity
@Table
public class LoginRegisterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String usertype;
    private String  email;
    private String name;
    private String phone;
    private String password;
    private String cpassword;



    public LoginRegisterModel(Long id, String usertype, String email, String name, String phone, String password, String cpassword) {
        this.id = id;
        this.usertype = usertype;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.cpassword = cpassword;
    }
   // @OneToMany(cascade = CascadeType.ALL,targetEntity = EventModel.class)
     //private List<EventModel> eventmodel=new ArrayList<>();



    public LoginRegisterModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }


   /* public List<EventModel> getEventmodel() {
        return eventmodel;
    }

    public void setEventmodel(List<EventModel> eventmodel) {
        this.eventmodel = eventmodel;
    }*/

}
