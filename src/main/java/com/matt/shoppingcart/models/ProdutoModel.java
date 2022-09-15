package com.matt.shoppingcart.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.matt.shoppingcart.DTOs.ProdutoDTO;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private Double preco;
	@NotNull
	private int qtd_estoque;
	
	public ProdutoModel() {
		super();
	}
	
	//Construtor padrao
	public ProdutoModel(String nome, Double preco, @NotNull int qtd_estoque) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.qtd_estoque = qtd_estoque;
	}
	
	//Construtor que recebe um ProdutoDTO
	public ProdutoModel(ProdutoDTO objDTO) {
		super();
		this.nome = objDTO.getNome();
		this.preco = objDTO.getPreco();
		this.qtd_estoque = objDTO.getQtd_estoque();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getQtd_estoque() {
		return qtd_estoque;
	}
	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}
	
	
	
}
