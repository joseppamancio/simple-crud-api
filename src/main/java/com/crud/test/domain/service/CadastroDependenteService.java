package com.crud.test.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.test.domain.model.Dependente;
import com.crud.test.domain.repository.DependenteRepository;

@Service
public class CadastroDependenteService {
	
	@Autowired
	private DependenteRepository dependenteRepository;
	
	
	public List<Dependente> listar() {
		return dependenteRepository.findAll();
	}
	
	public Dependente salvar(Dependente Dependente) {
		return dependenteRepository.save(Dependente);
	}
	
	public void excluir(Long DependenteId) {
		dependenteRepository.deleteById(DependenteId);
	}
	
	public Boolean verificarDependente(Long DependenteId) {
		if(!dependenteRepository.existsById(DependenteId)) {
			return false;
		}
		return true;
	}
	
	public Optional<Dependente> buscarDependente(Long DependenteId) {
		Optional<Dependente> Dependente = dependenteRepository.findById(DependenteId);	
		if(Dependente.isPresent()) {
			return Dependente;
		}
		return null;
	}
}
