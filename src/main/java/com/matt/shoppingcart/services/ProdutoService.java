package com.matt.shoppingcart.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matt.shoppingcart.DTOs.ProdutoDTO;
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

	public ProdutoModel obterPorId(Integer id) {
		Optional<ProdutoModel> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado!"));
	}

	public ProdutoModel cadastrarProduto(ProdutoDTO objDTO) {
		return produtoRepository.save(new ProdutoModel(objDTO));
	}

	public ProdutoModel atualizarProduto(Integer id, @Valid ProdutoDTO objDTO) {
		objDTO.setId(id);
		ProdutoModel produto = obterPorId(id);
		produto = new ProdutoModel(objDTO);
		return produtoRepository.save(produto);
	}

	public void deletarProduto(Integer id) {
		produtoRepository.deleteById(id);
	}
	
}
