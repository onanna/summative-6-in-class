package com.example.U1M6Summative.viewmodel;



import com.example.U1M6Summative.dto.Invoice;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerViewModel {

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

    List<Invoice> invoices = new ArrayList<>();

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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerViewModel)) return false;
        CustomerViewModel that = (CustomerViewModel) o;
        return getCustomerId().equals(that.getCustomerId()) &&
                getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName()) &&
                getEmail().equals(that.getEmail()) &&
                getCompany().equals(that.getCompany()) &&
                getPhone().equals(that.getPhone()) &&
                Objects.equals(getInvoices(), that.getInvoices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFirstName(), getLastName(), getEmail(), getCompany(), getPhone(), getInvoices());
    }
}
