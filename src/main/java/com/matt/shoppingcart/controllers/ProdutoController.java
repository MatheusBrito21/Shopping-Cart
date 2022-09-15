package com.matt.shoppingcart.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
