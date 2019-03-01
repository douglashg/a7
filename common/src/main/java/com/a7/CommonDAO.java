package com.a7;

import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Alternative
@Transactional
public class CommonDAO<T> {

  @Inject
  CommonJPA<T> commonJPA;

  public T getEntity() { return null;}

  public EntityManager getEntityManager() { return null;}

  @SuppressWarnings("unchecked")
  public T byId(Long id) { return (T) getEntityManager().find(getEntity().getClass(), id);}
  
  @SuppressWarnings("unchecked")
  public List<T> list(String json) { return getEntityManager().createQuery(commonJPA.jsonToHql(json)).getResultList();}
  
  public void insert(T entity) { getEntityManager().persist(entity);}

  public void update(T entity) { getEntityManager().merge(entity);}

  public void delete(T entity) { getEntityManager().remove(getEntityManager().merge(entity));}

}
