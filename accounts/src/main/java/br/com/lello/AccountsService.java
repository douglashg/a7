package br.com.lello;

import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "lancamentoService")
public class AccountsService extends ComumService<AccountsJPA> {

  @Inject
  AccountsDAO lancamentoDAO; 
  
}
