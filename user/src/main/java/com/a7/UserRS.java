package com.a7;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Default
@Path("/")
public class UserRS extends CommonRS<UserJPA> {
  
  @Inject
  UserService userService;
  
}