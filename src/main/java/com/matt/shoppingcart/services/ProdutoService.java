package com.matt.shoppingcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.shoppingcart.models.ProdutoModel;
import com.matt.shoppingcart.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	public List<ProdutoModel> obterTodos() {
		return produtoRepository.findAll();
	}
	
}
