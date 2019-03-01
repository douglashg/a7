package br.com.lello;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class AccountsDAO extends CommonDAO<AccountsJPA> {
    
  @Inject
  AccountsJPA lancamentoJPA; 
  
  @Override
  public AccountsJPA getEntity() {
    return new AccountsJPA();
  }
  
  @PersistenceContext(unitName="LancamentoPU")
  public EntityManager em;
  
  @Override
  public EntityManager getEntityManager() {
    return em;
  }
  
}
