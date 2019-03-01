package com.a7;

import javax.enterprise.inject.Alternative;
import javax.persistence.Entity;

@Alternative
public class CommonJPA<T> {

  public String jsonToHql(String json) {
    
    json = json.replace("}","").replace("{","").replaceAll("\n","").replaceAll(" ","").replaceAll("\t","").replaceAll("\":","=");
    String [] ar = json.split(",");
    json ="FROM " +super.getClass().getAnnotation(Entity.class).name();    
    
    if(ar!=null && ar.length>0 && !"".equals(ar[0])&& !"null".equals(ar[0])) {
      json = json+" WHERE "+ar[0].replaceFirst("\"","").replaceAll("\"","'");
      
      for (int i =1;i<ar.length;i++) {
        json = json+" AND "+ar[i].replaceFirst("\"","").replaceAll("\"","'");
      }
    }
    
    return json;   
  }
}
