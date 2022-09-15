package com.matt.shoppingcart.DTOs;

import javax.validation.constraints.NotNull;

import com.matt.shoppingcart.models.ProdutoModel;

public class ProdutoDTO {
	
	private Integer id;
	@NotNull(message = "O campo NOME é obrigatório!")
	private String nome;
	@NotNull(message = "O campo PREÇO é obrigatório!")
	private Double preco;
	private int qtd_estoque;
	
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer id, String nome,Double preco, int qtd_estoque) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.qtd_estoque = qtd_estoque;
	}

	public ProdutoDTO(ProdutoModel obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
		this.qtd_estoque = obj.getQtd_estoque();
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
