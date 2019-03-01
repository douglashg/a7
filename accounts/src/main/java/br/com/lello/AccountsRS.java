package br.com.lello;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class AccountsRS extends ComumRS<AccountsJPA> {
  
  @Inject
  AccountsService lancamentoService;
  
}