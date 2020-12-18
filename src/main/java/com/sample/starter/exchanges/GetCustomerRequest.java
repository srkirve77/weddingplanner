/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.sample.starter.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement GetRestaurantsRequest.
// Complete the class such that it is able to deserialize the incoming query params from
// REST API clients.
// For instance, if a REST client calls API
// /qeats/v1/restaurants?latitude=28.4900591&longitude=77.536386&searchFor=tamil,
// this class should be able to deserialize lat/long and optional searchFor from that.
@Data
public class GetCustomerRequest {
  
  @NonNull
  private String userName;
    
  @NonNull
  private String passWord;

  public GetCustomerRequest(String userName,String passWord) {
    this.userName = userName;
    this.passWord = passWord;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(@RequestParam(value = "user", required = true) String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return this.passWord;
  }

  public void setPassWord(@RequestParam(value = "password", required = true) String passWord) {
    this.passWord = passWord;
  }

}
