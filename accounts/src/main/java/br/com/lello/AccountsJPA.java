package br.com.lello;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Named;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Named
@Getter @Setter
@Entity(name = "lancamento")
@Table(name = "lancamento")
public class AccountsJPA extends ComumJPA implements Serializable { 
  
  public static final long serialVersionUID = 1L;
  
  @Id
  @Column(name="id_lancamento",columnDefinition="serial")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idLancamento;
  
  @Column(name="tipo",insertable=true,updatable=false,nullable=false)
  private Integer tipoLancamento;
  
  @Column(name="status",insertable=true,updatable=false,nullable=false)
  private Integer statusLancamento;
  
  @JsonbNumberFormat(value ="#0,00")
  @Column(name="valor",scale=2,insertable=true,updatable=false,nullable=false)
  private BigDecimal valorLancamento;
  
  @JsonbDateFormat(value="yyyyMMdd")
  @Column(name="inclusao",insertable=true,updatable=false,nullable=false)
  private Date inclusaoLancamento;
  
  @Column(name="id_usuario",insertable=true,updatable=false,nullable=false)
  private Long idUsuario;
  
  @Column(name="id_fornecedor",insertable=true,updatable=false,nullable=false)
  private Long idFornecedor;

  
}