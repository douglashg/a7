package br.com.lello;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class BoletoDAO extends ComumDAO<BoletoJPA> {
    
  @Inject
  BoletoJPA boletoJPA;
  
  @Override
  public BoletoJPA getEntity() {
    return new BoletoJPA();
  }
  
  @PersistenceContext(unitName="BoletoPU")
  public EntityManager em;
  
  @Override
  public EntityManager getEntityManager() {
    return em;
  }
  
}
