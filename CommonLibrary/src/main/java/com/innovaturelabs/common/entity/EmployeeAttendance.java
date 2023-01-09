package com.innovaturelabs.common.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
public class EmployeeAttendance {

    public static enum Status {
        INACTIVE((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;


    private byte status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    private Employee employee;

    public EmployeeAttendance(){

    }
    
    public EmployeeAttendance(Integer employeeId){
        this.status = EmployeeAttendance.Status.ACTIVE.value;
        this.employee = new Employee(employeeId);
        Date dt = new Date();
        this.date = dt;
    }
//    public EmployeeAttendance(Byte status,Integer employeeId){
//        this.status = status;
//        this.employee = new Employee(employeeId);
//        Date dt = new Date();
//        this.date = dt;
//    }
    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
