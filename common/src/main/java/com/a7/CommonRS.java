package com.a7;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Alternative
@ApplicationPath("/")
@Consumes(MediaType.APPLICATION_JSON+"; charset=UTF-8")
@Produces(MediaType.APPLICATION_JSON+"; charset=UTF-8")
public class CommonRS <T>{
   
  @Inject
  CommonService<T> commonService;
  
  @GET @Path("{id}")
  public T byId(@PathParam("id") Long id) { return (T) commonService.byId(id);}
  
  @POST @Path("list")
  public List<T> list(String json) { return commonService.list(json);}
  
  @POST
  public void insert(T entity) { commonService.insert(entity);}
  
  @PUT
  public void update(T entity) { commonService.update(entity);}
  
  @DELETE
  public void delete(T entity) { commonService.delete(entity);}
  
}