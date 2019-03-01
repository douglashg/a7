package br.com.lello;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Named
@Entity(name = "boleto")
@Table(name = "boleto")
public class BoletoJPA extends ComumJPA implements Serializable { 
  
  public static final long serialVersionUID = 1L;
  
  @Id
  @Column(name="id_condominio",columnDefinition="serial")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Long idCondominio;
  
  @Column(name="codigo_barras",unique=true,nullable=true,length=255)
  public String codigoBarras;
  
}