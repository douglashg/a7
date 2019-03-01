package br.com.lello;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class PessoaRS extends ComumRS<PessoaJPA> {
  
  @Inject
  PessoaService pessoaService;
  
}