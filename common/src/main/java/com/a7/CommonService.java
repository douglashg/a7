package com.a7;

import java.util.List;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
public class CommonService<T> {
	
  @Inject
  CommonDAO<T> commonDAO;
  
  public T byId(Long id) { return (T) commonDAO.byId(id);}
  
  public List<T> list(String json) { return (List<T>) commonDAO.list(json);}
  
  public void insert(T entity) { commonDAO.insert(entity);}
  
  public void update(T entity) { commonDAO.update(entity);}
  
  public void delete(T entity) { commonDAO.delete(entity);}
 
}
