package com.sample.starter.ds;




import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import javax.persistence.Column;


@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Vendor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vendor_id")
    private Integer vendorId;
    @Column(name="username")
    private String username;
    @Column(name="name")
    private String name;
    @Column(name="contact")
    private String contact;
    @Column(name="loggedin")
    private boolean loggedIn;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;

    public Vendor(String username,String password,String name,String contact,String email,boolean loggedIn) {
        this.vendorId=1;
        this.username=username;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.loggedIn = loggedIn;
    }

    public Integer getVendorId()
    {
        return this.vendorId;
    }
    public String getPassWord()
    {
        return this.password;
    }
    public String getUserName()
    {
        return this.username;
    }

    public boolean getUserLoggedIn() {
        return this.loggedIn;     
    }

    public void setLoggedIn(boolean status) {
        this.loggedIn = status;     
    }
    // public void SignUp(Vendor vendor);
    // public void SignIn(Vendor vendor);
    // public void SignOut(Vendor vendor);
    // public void UpdateInfo(Vendor vendor);

}