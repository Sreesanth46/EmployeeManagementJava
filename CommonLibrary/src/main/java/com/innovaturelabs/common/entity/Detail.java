package com.innovaturelabs.common.entity;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.innovaturelabs.common.form.DetailForm;


@Entity
public class Detail {
    public enum Status {
        DELETED((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String address;
    private String city;
    private String state;
    private String country;
    private byte status;
    private String profilePic;
    @OneToOne(optional= false,fetch = FetchType.LAZY )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Employee employee;
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(nullable = true,length = 64)
    private String photos;

    public Detail() {
    }
    public Detail(Integer id){
        this.id=id;
    }
    public Detail(DetailForm form, Integer employeeId) {
        this.employee = new Employee(employeeId);
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.dob = form.getDob();
        this.address = form.getAddress();
        this.city = form.getCity();
        this.state = form.getState();
        this.country = form.getCountry();
        this.phone = form.getPhone();
        this.status = Status.ACTIVE.value;
        this.profilePic=form.getProfilePic();
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }
    public Detail(int id,String firstName, String lastName,Date dob, String address, String city, String state, String country, byte status, String phone,String profilePic) {
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
    }
    
    public Detail updatec(DetailForm form) {
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.dob = form.getDob();
        this.address = form.getAddress();
        this.city = form.getCity();
        this.state = form.getState();
        this.country = form.getCountry();
        this.phone = form.getPhone();
        this.profilePic= form.getProfilePic();
        Date dt = new Date();
         this.updateDate = dt;
        return this;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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