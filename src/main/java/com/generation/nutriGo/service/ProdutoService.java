package com.generation.nutriGo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.nutriGo.model.Produto;
import com.generation.nutriGo.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	public List<Produto> recomendarProdutos() {

	    List<Produto> produtos = produtoRepository.findAll();

	    if (produtos.isEmpty()) {
	        return Collections.emptyList();
	    }

	    Collections.shuffle(produtos);

	    return produtos.stream()
	            .limit(2)
	            .toList();
	}

}
