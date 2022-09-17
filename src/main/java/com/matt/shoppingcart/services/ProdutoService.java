package com.matt.shoppingcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.shoppingcart.models.ProdutoModel;
import com.matt.shoppingcart.repositories.ProdutoRepository;
import com.matt.shoppingcart.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	//findAll Produtos
	public List<ProdutoModel> obterTodos() {
		return produtoRepository.findAll();
	}
	
	public List<ProdutoModel>obterPorNome(String nome) {
		List<ProdutoModel> query = produtoRepository.findAllNome(nome);
		if(query.isEmpty()) {
			throw new ObjectNotFoundException("Produto não encontrado!");
		}
		return query;
	}
	
}
