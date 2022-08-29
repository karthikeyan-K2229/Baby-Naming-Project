package com.project.babynaming.entity;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventid;
    private String eventName;
    private String applicantName;
    private String applicantAddress;
    private String applicantMobileNo;
    private String applicantEmailId;
    private String eventAddress;
    private String eventDate;
    private String eventTime;
    private String noOfPeople;
    private String selectFoodCategory;
    private String quantityOfVeg;
    private String quantityOfNonVeg;
    private  String loggedUser;
    private Long userId;
    private int addOnPrice;
    private int themePrice;

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    public int getaddOnPrice() {
        return addOnPrice;
    }

    public void setaddOnPrice(int addOnPrice) {
        this.addOnPrice = addOnPrice;
    }

    public int getthemePrice() {
        return themePrice;
    }

    public void setthemePrice(int themePrice) {
        this.themePrice = themePrice;
    }

    public EventModel(Long eventid, String eventName, String applicantName, String applicantAddress, String applicantMobileNo, String applicantEmailId, String eventAddress, String eventDate, String eventTime, String noOfPeople, String selectFoodCategory, String quantityOfVeg, String quantityOfNonVeg,long userId,int themePrice,int addOnPrice) {
        this.eventid = eventid;
        this.eventName = eventName;
        this.applicantName = applicantName;
        this.applicantAddress = applicantAddress;
        this.applicantMobileNo = applicantMobileNo;
        this.applicantEmailId = applicantEmailId;
        this.eventAddress = eventAddress;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.noOfPeople = noOfPeople;
        this.selectFoodCategory = selectFoodCategory;
        this.quantityOfVeg = quantityOfVeg;
        this.quantityOfNonVeg = quantityOfNonVeg;
        this.loggedUser=loggedUser;
        this.userId=userId;
        this.themePrice = themePrice;
        this.addOnPrice = addOnPrice;
    }

    public EventModel() {
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public Long getUserid() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    public String getApplicantMobileNo() {
        return applicantMobileNo;
    }

    public void setApplicantMobileNo(String applicantMobileNo) {
        this.applicantMobileNo = applicantMobileNo;
    }

    public String getApplicantEmailId() {
        return applicantEmailId;
    }

    public void setApplicantEmailId(String applicantEmailId) {
        this.applicantEmailId = applicantEmailId;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(String noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public String getSelectFoodCategory() {
        return selectFoodCategory;
    }

    public void setSelectFoodCategory(String selectFoodCategory) {
        this.selectFoodCategory = selectFoodCategory;
    }

    public String getQuantityOfVeg() {
        return quantityOfVeg;
    }

    public void setQuantityOfVeg(String quantityOfVeg) {
        this.quantityOfVeg = quantityOfVeg;
    }

    public String getQuantityOfNonVeg() {
        return quantityOfNonVeg;
    }

    public void setQuantityOfNonVeg(String quantityOfNonVeg) {
        this.quantityOfNonVeg = quantityOfNonVeg;
    }



    /*public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }*/
    @Builder(builderMethodName="builder")
    public static EventModel newTheme(Long eventid, String eventName, String applicantName, String applicantAddress, String applicantMobileNo, String applicantEmailId, String eventAddress, String eventDate, String eventTime, String noOfPeople, String selectFoodCategory, String quantityOfVeg, String quantityOfNonVeg,long userId,int themePrice,int addOnPrice) {
        return new EventModel(eventid,eventName,applicantName,applicantAddress,applicantMobileNo,applicantEmailId,eventAddress,eventDate,eventTime,noOfPeople,selectFoodCategory,quantityOfVeg,quantityOfNonVeg,userId,themePrice,addOnPrice);
    }
}
