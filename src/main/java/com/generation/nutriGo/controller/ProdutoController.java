package com.generation.nutriGo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.nutriGo.model.Produto;
import com.generation.nutriGo.repository.ProdutoRepository;
import com.generation.nutriGo.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> selecionarTodos() {
		return ResponseEntity.ok(produtoRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> selecionarPorId(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> selecionarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));

	}
	
	@GetMapping("/recomendacoes")
	public ResponseEntity<List<Produto>> recomendarProduto(){
		
		return ResponseEntity.ok(produtoService.recomendarProdutos());
		
	}

	@PostMapping
	public ResponseEntity<Produto> cadastrarProduto(@Valid @RequestBody Produto produto) {
		produto.setId(null);

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));

	}

	@PutMapping
	public ResponseEntity<Produto> atualizarProduto(@Valid @RequestBody Produto produto) {

		if (produtoRepository.existsById(produto.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {

		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		produtoRepository.deleteById(id);

	}

}
