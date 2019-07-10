package com.example.U1M6Summative.viewmodel;

import com.example.U1M6Summative.dto.Invoice;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerViewModel {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;

    public CustomerViewModel() {
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
        CustomerViewModel customerViewModel = (CustomerViewModel) o;
        return getCustomerId() == customerViewModel.getCustomerId() &&
                Objects.equals(getFirstName(), customerViewModel.getFirstName()) &&
                Objects.equals(getLastName(), customerViewModel.getLastName()) &&
                Objects.equals(getEmail(), customerViewModel.getEmail()) &&
                Objects.equals(getCompany(), customerViewModel.getCompany()) &&
                Objects.equals(getPhone(), customerViewModel.getPhone());
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
