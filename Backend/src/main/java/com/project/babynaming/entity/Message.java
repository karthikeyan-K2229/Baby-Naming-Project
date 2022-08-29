package com.project.babynaming.entity;


import java.util.ArrayList;
import java.util.List;

public class Message {
    private String message = "";
    private List<AddOn> add_on = new ArrayList<AddOn>();
    private int statusCode;
    private String error = "";
    public Object HttpStatus;

    public Message(String message, List<AddOn> add_on, String error, int statusCode) {
        this.message = message;
        this.add_on = add_on;
        this.error = error;
        this.statusCode= statusCode;
    }


	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String string, List<AddOn> asList, String string2) {
		// TODO Auto-generated constructor stub
	}


	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AddOn> getFoods(){
        return add_on;
    }

    public void setFoods(ArrayList<AddOn> foods) {

        this.add_on = foods;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}


