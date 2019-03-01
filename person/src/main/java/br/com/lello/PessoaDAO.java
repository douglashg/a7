package br.com.lello;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class PessoaDAO extends ComumDAO<PessoaJPA> {
    
  @Inject
  PessoaJPA pessoaJPA; 
  
  @Override
  public PessoaJPA getEntity() {
    return new PessoaJPA();
  }
  
  @PersistenceContext(unitName="PessoaPU")
  public EntityManager em;
  
  @Override
  public EntityManager getEntityManager() {
    return em;
  }
  
}
