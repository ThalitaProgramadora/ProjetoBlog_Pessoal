package com.blog.Pessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="tb_Tema")
public class Tema {
  @GeneratedValue(strategy = GenerationType.IDENTITY)	
  private @Id long id;
  private @NotNull @Size(min = 5, max = 50, message = "Error Size")String descricao;
  //estamos mapeando a tabela tema
  @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
  //apartir de qual propriedade que vamos ignorar 
  //nessa caso é tema para ter recursividade.
  @JsonIgnoreProperties("tema")
  private List<Postagem>postagem;
  
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public List<Postagem> getPostagem() {
	return postagem;
}
public void setPostagem(List<Postagem> postagem) {
	this.postagem = postagem;
}
  
}
