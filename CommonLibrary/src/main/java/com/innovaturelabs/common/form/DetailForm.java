package com.innovaturelabs.common.form;


import java.util.Date;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innovaturelabs.common.json.Json;

public class DetailForm {
    @Size(max = 30)
    @NotBlank
    private String firstName;
    @Size(max = 30)
    private String lastName;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",timezone="Asia/Kolkata")
    private Date dob;
    @Size(max = 200)
    private String address;
    @Size(max = 50)
    private String city;
    @Size(max = 50)
    private String state;
    @Size(max = 50)
    private String country;
    private String phone;

    private String photos;

    private String profilePic;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
