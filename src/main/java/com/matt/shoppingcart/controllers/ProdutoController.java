package com.matt.shoppingcart.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matt.shoppingcart.DTOs.ProdutoDTO;
import com.matt.shoppingcart.models.ProdutoModel;
import com.matt.shoppingcart.services.ProdutoService;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> obterTodos(){
		List<ProdutoModel> lista = service.obterTodos();
		List<ProdutoDTO> listaDTO = lista.stream().map(x-> new ProdutoDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@GetMapping(path = "/pesquisar/{nome}")
	public ResponseEntity<List<ProdutoDTO>> obterPorNome(@PathVariable String nome){
		List<ProdutoModel> p = service.obterPorNome(nome);
		List<ProdutoDTO> lista = p.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProdutoDTO> obterPorId(@PathVariable Integer id){
		ProdutoModel produto = service.obterPorId(id);
		return ResponseEntity.ok().body(new ProdutoDTO(produto));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody @Valid ProdutoDTO objDTO){
		ProdutoModel produto = service.cadastrarProduto(objDTO);
		return ResponseEntity.ok().body(new ProdutoDTO(produto));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Integer id , @Valid @RequestBody ProdutoDTO objDTO){
		ProdutoModel produto = service.atualizarProduto(id,objDTO);
		return ResponseEntity.ok().body(new ProdutoDTO(produto));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Integer id){
		service.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
	
}
