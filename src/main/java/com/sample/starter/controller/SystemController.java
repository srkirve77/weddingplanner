package com.sample.starter.controller;

import com.sample.starter.ds.*;
import com.sample.starter.exchanges.*;
import com.sample.starter.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemController {

  @Autowired
  CustomerService customerService;
  
  @Autowired
  VendorService vendorService;

  @Autowired
  VenueService venueService;

  @Autowired
  CateringService cateringService;

  @Autowired
  OrderService orderService;

  @GetMapping("/wedding")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok().body("Hello World!");
  }

  @GetMapping("/isUserLoggedIn/{userName}") 
  public ResponseEntity<String> isUserLoggedIn(@PathVariable("userName")String userName)
  {
    Customer customer = customerService.findCustomer(userName);
    if(customer!=null)
      return new ResponseEntity<>("Successful", HttpStatus.OK);
    return new ResponseEntity<>("WRONGDATA",HttpStatus.BAD_GATEWAY);  

  } 

  @GetMapping("/logoutUser/{userName}") 
  public ResponseEntity<String> logoutUser(@PathVariable("userName")String userName)
  {
    try{
    Customer customer = customerService.findCustomer(userName);
    customer.setLoggedIn(false);
    }
    catch(NullPointerException e) {

    }
    return new ResponseEntity<>("Successful",HttpStatus.OK);  

  } 

  @GetMapping(value = "/signInCustomer/{userName}/{passWord}",produces={"text/html","text/html"})
  public ResponseEntity<String> signInCustomer(@PathVariable("userName")String userName, @PathVariable("passWord")String passWord) {
    GetCustomerRequest getCustomerRequest = new GetCustomerRequest(userName,passWord);
    boolean flag = customerService.SignIn(getCustomerRequest);
    if(flag)
      return new ResponseEntity<>("Successful.", HttpStatus.OK);
    return new ResponseEntity<>("WRONGDATA",HttpStatus.BAD_GATEWAY);  
  }

  @GetMapping(value = "/signInVendor/{userName}/{passWord}",produces={"text/html","text/html"})
  public ResponseEntity<String> signInVendor(@PathVariable("userName")String userName, @PathVariable("passWord")String passWord) {
    GetVendorRequest getVendorRequest = new GetVendorRequest(userName,passWord);
    boolean flag = vendorService.SignIn(getVendorRequest);
    if(flag)
      return new ResponseEntity<>("Successful.", HttpStatus.OK);
    return new ResponseEntity<>("WRONGDATA",HttpStatus.BAD_GATEWAY);  
  }

  @PostMapping("/signUpCustomer/{customerId}/{customerName}/{passWord}/{email}/{user_name}/{loggedIn}/{contact}")
  public ResponseEntity<String> signUpCustomer(
    @PathVariable("customerId")Integer customerId,
    @PathVariable("customerName")String customerName,
    @PathVariable("passWord")String passWord,  
    @PathVariable("email")String email,
    @PathVariable("user_name")String userName,
    @PathVariable("loggedIn")boolean loggedIn,
    @PathVariable("contact")String contact
  ) {
    Customer customer = new Customer(userName,customerName,passWord,contact,email,loggedIn);
    boolean flag = customerService.SignUp(customer);
    System.out.println(flag +" "+ customer.getUserName());
    if(flag)
    {
      
      return new ResponseEntity<>("Successful.", HttpStatus.OK);
    }
    return new ResponseEntity<>("Successful",HttpStatus.BAD_GATEWAY);  
  }

  @PostMapping("/signUpVendor/{username}/{password}/{name}/{contact}/{email}")
  public ResponseEntity<String> signUpVendor(
    @PathVariable("username")String username,
    @PathVariable("password")String password,  
    @PathVariable("name")String name,
    @PathVariable("contact")String contact,
    @PathVariable("email")String email
  ) {
    Vendor vendor = new Vendor(username,password,name,contact,email,true);
    boolean flag = vendorService.SignUp(vendor);
    System.out.println("done register vendor");
    if(flag)
    {      
      System.out.println("outside register vendor");
      return new ResponseEntity<>("Successful.", HttpStatus.OK);
    }
    return new ResponseEntity<>("Successful",HttpStatus.BAD_GATEWAY);  
  }

  @PostMapping("/registerVenue/{username}/{v_name}/{price}/{v_add}/{seatingcap}")
  public ResponseEntity<String> registerVenue(
    
    @PathVariable("username")String username,    
    @PathVariable("v_name")String v_name,
    @PathVariable("price")Integer price,  
    @PathVariable("v_add")String v_add,
    @PathVariable("seatingcap")Integer seatingcap
  ) {
    System.out.println("inside register venue");
    Venue venue = new Venue(v_name,price,seatingcap,v_add);
    Vendor vendor = vendorService.findVendor(username);
    venue.setVendorId(vendor.getVendorId());
    venueService.VenueRegistration(venue);
    return new ResponseEntity<>("Successful.", HttpStatus.OK);  
  }

  @PostMapping("/registerCatering/{username}/{c_name}/{price}/{c_add}/{cap}")
  public ResponseEntity<String> registerCatering(
    
    @PathVariable("username")String username,    
    @PathVariable("c_name")String c_name,
    @PathVariable("price")Integer price,  
    @PathVariable("c_add")String c_add,
    @PathVariable("cap")Integer cap
  ) {
    Catering catering = new Catering(c_name,price,cap,c_add);
    Vendor vendor = vendorService.findVendor(username);
    catering.setVendorId(vendor.getVendorId());
    return new ResponseEntity<>("Successful.", HttpStatus.OK);  
  }

  @PostMapping("/paymentGateway/{username}/{service_id}/{date}")
  public ResponseEntity<String> paymentGateway(
    @PathVariable("username")String username,
    @PathVariable("service_id")Integer service_id,
    @PathVariable("date")LocalDate date
  ) {
      Customer customer = customerService.findCustomer(username);
      Catering catering = cateringService.findCatering(service_id);
      Order order = new Order(customer.getCustomerId(),catering.getVendorId(),date, service_id,catering.getPrice());
      orderService.CreateOrder(order);
      return new ResponseEntity<>("Successful.", HttpStatus.OK);  
  }

  @GetMapping("/checkAvailability/{service_id}/{date}")
  public ResponseEntity<String>checkAvailability(
    @PathVariable("service_id")Integer service_id,
    @PathVariable("date")LocalDate date
  )
  {
    boolean flag = orderService.findOrder(service_id, date);
    if(flag)
      return new ResponseEntity<>("Successful.", HttpStatus.OK);  
    else
      return new ResponseEntity<>("Successful.", HttpStatus.BAD_GATEWAY);  

  }
}
