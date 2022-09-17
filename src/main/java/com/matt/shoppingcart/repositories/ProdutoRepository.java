package com.matt.shoppingcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matt.shoppingcart.models.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
	
	@Query("from ProdutoModel where nome like %:nome%")
	List<ProdutoModel> findAllNome(@Param("nome") String nome);

}
