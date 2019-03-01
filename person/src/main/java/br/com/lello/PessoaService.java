package br.com.lello;

import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "pessoaService")
public class PessoaService extends ComumService<PessoaJPA> {

  @Inject
  PessoaDAO loginDAO; 
  
}
