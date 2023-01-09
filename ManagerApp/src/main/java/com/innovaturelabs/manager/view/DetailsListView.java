package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Detail;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class DetailsListView {

    private final Integer employeeId;
    private final String employeeName;
    private final Integer detailId;
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final String phone;
    private final byte status;


    public DetailsListView(Detail detail) {
        this.employeeId = detail.getEmployee().getEmployeeId();
        this.employeeName = detail.getEmployee().getEmployeeName();
        this.detailId = detail.getId();
        this.firstName = detail.getFirstName();
        this.lastName = detail.getLastName();
        this.dateOfBirth = detail.getDob();
        this.address = detail.getAddress();
        this.city = detail.getCity();
        this.state = detail.getState();
        this.country = detail.getCountry();
        this.phone = detail.getPhone();
        this.status = detail.getStatus();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
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

    public String getState() {
        return state;
    }
}
