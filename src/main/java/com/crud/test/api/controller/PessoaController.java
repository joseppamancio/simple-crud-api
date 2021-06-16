package com.crud.test.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.test.api.model.PessoaModel;
import com.crud.test.domain.model.Pessoa;
import com.crud.test.domain.service.CadastroPessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private CadastroPessoaService cadastroPessoaService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//------- LISTAR -------//
	@GetMapping
	public List<Pessoa> listar() throws ParseException {
		return cadastroPessoaService.listar();
	}
	
	
	
	//------- BUSCAR POR ID -------//
	@GetMapping("/{pessoaId}")
	public ResponseEntity <PessoaModel> buscar(@PathVariable Long pessoaId) {		
		Optional<Pessoa> pessoa = cadastroPessoaService.buscarPessoa(pessoaId);
		if(pessoa != null) {
			PessoaModel pessoaModel = toModel(pessoa.get());
			return ResponseEntity.ok(pessoaModel);
		}
		return ResponseEntity.notFound().build();	//ResponseEntity faz a trataiva de resposta HTTP
	}
	
	
	
	//------- BUSCAR POR NOME -------//
	@GetMapping("/nome/{nomePessoa}")
	public ResponseEntity<ListIterator<PessoaModel>> buscarNome(@PathVariable String nomePessoa) {		
		List<PessoaModel> pessoaModel = toCollectionModel(cadastroPessoaService.buscarPessoaPorNome(nomePessoa));
		if(pessoaModel != null) {
			return ResponseEntity.ok(pessoaModel.listIterator());
		}
		return ResponseEntity.notFound().build();	//ResponseEntity faz a trataiva de resposta HTTP
	}
	

	
	//------- ADICIONAR -------//
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaModel adicionar(@Valid @RequestBody Pessoa pessoa) {
		return toModel(cadastroPessoaService.salvar(pessoa));
	}
	
	
	
	//------- ATUALIZAR -------//
	@PutMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> atualizar(@Valid @PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {
		if(cadastroPessoaService.verificarPessoa(pessoaId)) {
			pessoa.setId(pessoaId);
			pessoa = cadastroPessoaService.salvar(pessoa);
			return ResponseEntity.ok(pessoa);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	//------- DELETAR -------//
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Void> remover(@PathVariable Long pessoaId){
		if(cadastroPessoaService.verificarPessoa(pessoaId)) {
			cadastroPessoaService.excluir(pessoaId);
			return ResponseEntity.noContent().build();
		}		
		return ResponseEntity.notFound().build();
	}
	
	
	
	//------ CONVERSÃO ENTIDADE PARA MODELO -----//
	private PessoaModel toModel(Pessoa pessoa) {
		PessoaModel pessoaModel = modelMapper.map(pessoa,PessoaModel.class);
		return pessoaModel;
	}
	
	private List<PessoaModel> toCollectionModel(List<Pessoa> pessoas){
		return pessoas.stream()
				.map(pessoa -> toModel(pessoa))
				.collect(Collectors.toList());		
	}

}
