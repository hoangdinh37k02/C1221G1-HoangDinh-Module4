package com.codegym.controller;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class FormDto {
    private Integer formId;
    @NotEmpty(message = "Not Null")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty(message = "Not Null")
    @Size(min = 5, max = 45)
    private String lastName;
    @Range(min = 18, max = 110, message = "your age is between 18 to 110")
    private Integer age;
    @NotEmpty(message = "Not Null")
    @Email
    private String email;
    @NotEmpty(message = "Not Null")
    @Pattern(regexp = "^[0][0-9]{9}$", message = "phone begin number zero and has 10 number")
    private String phone;

    public FormDto() {
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
