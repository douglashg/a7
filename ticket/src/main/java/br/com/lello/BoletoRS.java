package br.com.lello;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/")
public class BoletoRS extends ComumRS<BoletoJPA> {
  
  @Inject
  BoletoService boletoService;
  
}