package com.innovaturelabs.employee.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innovaturelabs.common.entity.Detail;
import java.util.Date;
public class DetailListView {
    
    private final int id;
    private final String firstName;
    private final String lastName;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="Asia/Kolkata")
    private final Date dob;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final byte status;
    private final String phone;

    private final String profilePic;

    private final String photos;

    public DetailListView(int id,String firstName, String lastName,Date dob, String address, String city, String state, String country, byte status, String phone,String profilePic,String photos) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.status = status;
        this.phone = phone;
        this.profilePic=profilePic;
        this.photos=photos;
    }

     public DetailListView(Detail detail) {
         this.id = detail.getId();
         this.firstName = detail.getFirstName();
         this.lastName = detail.getLastName();
         this.dob = detail.getDob();
         this.address = detail.getAddress();
         this.city = detail.getCity();
         this.state = detail.getState();
         this.country = detail.getCountry();
         this.status = detail.getStatus();
         this.phone = detail.getPhone();
         this.profilePic=detail.getProfilePic();
         this.photos=detail.getPhotos();
     }
    public int getId() {
        return id;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public byte getStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getPhotos() {
        return photos;
    }
}
