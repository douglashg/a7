package br.com.lello;
import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Named
@Entity(name = "pessoa")
@Table(name = "pessoa")
public class PessoaJPA extends ComumJPA implements Serializable { 
  
  public static final long serialVersionUID = 1L;
  
  @Id
  @Column(name="id_pessoa",unique=true,insertable=true,updatable=false,nullable=false)
  public Long idPessoa;
    
  @Column(name="nome",nullable=false,length=255)
  public String nome;

  @Column(name="nascimento",nullable=false)
  public Date nascimento;
  
  @Column(name="id_usuario",unique=true,insertable=true,updatable=false,nullable=false)
  public Long idUsuario;
  
}