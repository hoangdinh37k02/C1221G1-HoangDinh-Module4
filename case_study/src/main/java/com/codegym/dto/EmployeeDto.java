package com.codegym.dto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.Education;
import com.codegym.model.employee.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private int employeeId;
    @Pattern(regexp = "^([A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+\\s{0,}){1,}$", message = "Not null or number in name")
    private String employeeName;
    private String birthDay;
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$", message = "The ID Card include 9 or 12 number")
    private String idCard;
    @Pattern(regexp = "^[1-9]{1}[0-9]{0,}$",message = "must be postive")
    private String salary;
    @Pattern(regexp = "^([0]{1}[0-9]{9})$", message = "phone number must start by number 0 and include 10 number")
    private String phone;
    @Email
    private String email;
    private String address;
    private Position position;
    private Education education;
    private Division division;

    public EmployeeDto() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
