package com.a7;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

@Default
public class UserService extends CommonService<UserJPA> {

  @Inject
  UserDAO userDAO; 
  
}
