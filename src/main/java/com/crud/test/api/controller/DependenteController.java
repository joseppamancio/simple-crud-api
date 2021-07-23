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

import com.crud.test.api.model.DependenteModel;
import com.crud.test.domain.model.Dependente;
import com.crud.test.domain.model.Pessoa;
import com.crud.test.domain.repository.PessoaRepository;
import com.crud.test.domain.service.CadastroDependenteService;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {
	
	@Autowired
	private CadastroDependenteService cadastroDependenteService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//------- LISTAR -------//
	@GetMapping
	public List<Dependente> listar() throws ParseException {
		return cadastroDependenteService.listar();
	}
	
	
	
	//------- BUSCAR POR ID -------//
	@GetMapping("/{dependenteId}")
	public ResponseEntity <DependenteModel> buscar(@PathVariable Long dependenteId) {		
		Optional<Dependente> dependente = cadastroDependenteService.buscarDependente(dependenteId);
		if(dependente != null) {
			DependenteModel dependeteModel = toModel(dependente.get());
			return ResponseEntity.ok(dependeteModel);
		}
		return ResponseEntity.notFound().build();	//ResponseEntity faz a trataiva de resposta HTTP
	}
	
	
	
	//------- BUSCAR POR NOME -------//
	@GetMapping("/nome/{nomeDependente}")
	public ResponseEntity<ListIterator<DependenteModel>> buscarNome(@PathVariable String nomeDependente) {		
		List<DependenteModel> dependenteModel = toCollectionModel(cadastroDependenteService.buscarDependentePorNome(nomeDependente));
		if(dependenteModel != null) {
			return ResponseEntity.ok(dependenteModel.listIterator());
		}
		return ResponseEntity.notFound().build();	//ResponseEntity faz a trataiva de resposta HTTP
	}
	
	
	//------- ADICIONAR -------//
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DependenteModel adicionar(@Valid @RequestBody Dependente dependente) {
		Pessoa pessoa = pessoaRepository.findById(dependente.getPessoa().getId())
				.orElseThrow(null);
		
		dependente.setPessoa(pessoa);
		return toModel(cadastroDependenteService.salvar(dependente));
	}
	
	
	
	//------- ATUALIZAR -------//
	@PutMapping("/{dependenteId}")
	public ResponseEntity<Dependente> atualizar(@Valid @PathVariable Long dependenteId, @RequestBody Dependente dependente) {
		if(cadastroDependenteService.verificarDependente(dependenteId)) {
			dependente.setId(dependenteId);
			dependente = cadastroDependenteService.salvar(dependente);
			return ResponseEntity.ok(dependente);
		}

		return ResponseEntity.notFound().build();
	}
	
	
	
	//------- DELETAR -------//
	@DeleteMapping("/{dependenteId}")
	public ResponseEntity<Void> remover(@PathVariable Long dependenteId){
		if(cadastroDependenteService.verificarDependente(dependenteId)) {
			cadastroDependenteService.excluir(dependenteId);	
			return ResponseEntity.noContent().build();
		}		

		return ResponseEntity.notFound().build();
	}

	
	
	//----- CONVERSÃO ENTIDADE PARA MODELO -----//
	private DependenteModel toModel(Dependente dependente) {
		DependenteModel dependenteModel = modelMapper.map(dependente,DependenteModel.class);
		return dependenteModel;
	}
	
	private List<DependenteModel> toCollectionModel(List<Dependente> dependentes){
		return dependentes.stream()
				.map(dependente -> toModel(dependente))
				.collect(Collectors.toList());		
	}
}
