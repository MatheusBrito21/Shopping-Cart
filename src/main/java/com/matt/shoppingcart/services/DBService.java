package com.matt.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.shoppingcart.models.ProdutoModel;
import com.matt.shoppingcart.repositories.ProdutoRepository;

@Service
public class DBService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void instanciaDB() {
		
		List<ProdutoModel> listaProdutosPadrao = new ArrayList<>();
		
		listaProdutosPadrao.add(new ProdutoModel("Jogador Numero 1", 39.9, 100));
		listaProdutosPadrao.add(new ProdutoModel("Jogador Numero 2", 49.9, 100));
		listaProdutosPadrao.add(new ProdutoModel("O Iluminado", 29.9, 50));
		listaProdutosPadrao.add(new ProdutoModel("Percy Jackson e os Olimpianos - O Ladrão de Raios", 19.9, 80));
		listaProdutosPadrao.add(new ProdutoModel("Uma Breve História do Mundo", 19.9, 20));
		
		produtoRepository.saveAll(listaProdutosPadrao);
		
		
		
	}
}
