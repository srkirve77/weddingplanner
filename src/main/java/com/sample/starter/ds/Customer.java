package com.sample.starter.ds;


import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import javax.persistence.Column;

@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
    @Column(name="userName")
    private String userName;
    @Column(name="customerName")
    private String customerName;
    @Column(name="passWord")
    private String PassWord;
    @Column(name="contact")
    private String contact;
    @Column(name="email")
    private String email;
    @Column(name="loggedIn")
    private boolean loggedIn;
    public Customer( String userName,String customerName,String PassWord,String contact,String email,Boolean loggedIn) 
    {
        //this.customerID = customerId;
        this.userName = userName;
        this.customerName = customerName;
        this.PassWord = PassWord;
        this.contact = contact;
        this.email = email;
        this.loggedIn = loggedIn;
    }
    public Integer getCustomerId() {
        return this.customerID;
    }
    public String getPassWord()
    {
        return this.PassWord;
    }
    public String getUserName()
    {
        return this.userName;
    }

    public boolean getUserLoggedIn() {
        return this.loggedIn;     
    }

    public void setLoggedIn(boolean status) {
        this.loggedIn = status;     
    }
    // public boolean SignUp(Customer customer);
    // public boolean SignIn(GetCustomerRequest getCustomerRequest);
    // public void SignOut(Customer customer);
    // public Customer findCustomer(String userName);
    // public void UpdateInfo(Customer customer);
}