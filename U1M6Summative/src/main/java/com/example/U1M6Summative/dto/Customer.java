package com.example.U1M6Summative.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Customer {

    private Integer customerId;

    @NotNull(message = "first Name input cannot be null")
    @NotBlank(message = "You have to have an input for First name")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @NotBlank(message = "You have to have an input for Last name")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "You have to have an input for Email")
    private String email;

    @NotNull(message = "Company cannot be null")
    @NotBlank(message = "You have to have an input for Company")
    private String company;

    @NotNull(message = "Phone cannot be null")
    @NotBlank(message = "You have to have an input for Phone")
    private String phone;

    public Customer() {
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getCompany(), customer.getCompany()) &&
                Objects.equals(getPhone(), customer.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(),
                getFirstName(),
                getLastName(),
                getEmail(),
                getCompany(),
                getPhone());
    }
}

