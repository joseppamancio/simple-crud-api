package com.crud.test.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.test.domain.model.Pessoa;
import com.crud.test.domain.repository.PessoaRepository;

@Service
public class CadastroPessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void excluir(Long pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}
	
	public Boolean verificarPessoa(Long pessoaId) {
		if(!pessoaRepository.existsById(pessoaId)) {
			return false;
		}
		return true;
	}
	
	public Optional<Pessoa> buscarPessoa(Long pessoaId) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);	
		if(pessoa.isPresent()) {
			return pessoa;
		}
		return null;
	}
	
	public List<Pessoa> buscarPessoaPorNome(String nomePessoa) {
		List<Pessoa> pessoas = pessoaRepository.findByNomeContaining(nomePessoa);	
		if(!pessoas.isEmpty()) {
			return pessoas;
		}
		return null;
	}
}
