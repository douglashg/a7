package com.a7;

import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Default
@Getter @Setter
@Entity(name = "users")
@Table(name = "users")
public class UserJPA extends CommonJPA<UserJPA> implements Serializable { 
  
  public static final long serialVersionUID = 1L;
  
  @Id
  @Column(name="id_user",columnDefinition="serial")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idUser;
  
  @Column(name="name",unique=true,nullable=false,length=12)
  private String name;

  @Column(name="password",nullable=false,length=8)
  private String password;
  
  @Column(name="identification",unique=true,nullable=false,length=14)
  private Long identification;
  
  @Column(name="country",nullable=false,length=2)
  private Integer country;
  
  @Column(name="ddd",nullable=false,length=2)
  private Integer ddd;
  
  @Column(name="mobile",unique=true,nullable=false,length=14)
  private Long mobile;
  
  @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Email inválido")
  @Column(name="email",unique=true,nullable=false,length=140)
  private String email;
  
  @Column(name="type",nullable=false)
  private Integer typeUser;
  
  @Column(name="login")
  private Boolean login;
  
  @Column(name="token",unique=true,nullable=false)
  private String token;
}