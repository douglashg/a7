package br.com.lello;

import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "boletoService")
public class BoletoService extends ComumService<BoletoJPA> {

  @Inject
  BoletoDAO boletoDAO;
  
}
