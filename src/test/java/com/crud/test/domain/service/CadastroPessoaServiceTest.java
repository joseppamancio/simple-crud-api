package com.crud.test.domain.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.crud.test.domain.model.EstadoCivil;
import com.crud.test.domain.model.Pessoa;
import com.crud.test.domain.repository.PessoaRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class CadastroPessoaServiceTest {

	  @Autowired
	  private CadastroPessoaService cadastroPessoaService;

	  @Autowired
	  private PessoaRepository pessoaRepository;
	  
	  private Pessoa pessoa;
	  
	  @BeforeEach
	  public void init() {
		  
		  pessoa = new Pessoa("Joyce de Campos Matos", "42313855079");
		  pessoa.setIdade(28);
		  pessoa.setProfissao("Balconista");
		  pessoa.setEstadoCivil(EstadoCivil.CASADO);
		  pessoa.setBairro("Jardim da Oliveiras");
		  pessoa.setCidade("São José dos Campos");
		  pessoa.setEndereco("Rua São Marcos, 536");
		  pessoa.setEstado("São Paulo");
		  
	  }
	  
	  @Test
	  public void salvarPessoaTest() {
		  
		  cadastroPessoaService.salvar(pessoa);

		  Pessoa pessoaEncontrada = pessoaRepository.findAll().stream()
	        .filter(p -> p.getNome().equals("Joyce de Campos Matos")).findFirst().get();

		  assertEquals("Joyce de Campos Matos", pessoaEncontrada.getNome());
		  assertEquals(28, pessoaEncontrada.getIdade());
		  assertEquals("Balconista", pessoaEncontrada.getProfissao());
		  assertEquals(EstadoCivil.CASADO, pessoaEncontrada.getEstadoCivil());
		  assertEquals("Jardim da Oliveiras", pessoaEncontrada.getBairro());
		  assertEquals("São José dos Campos", pessoaEncontrada.getCidade());
		  assertEquals("Rua São Marcos, 536", pessoaEncontrada.getEndereco());
		  assertEquals("São Paulo", pessoaEncontrada.getEstado());
	  }
	  
	  
	  @AfterEach
	  public void excluirTest() {
		  
		Pessoa pessoaEncontrada = pessoaRepository.findAll().stream()
			       .filter(p -> p.getNome().equals("Joyce de Campos Matos")).findFirst().get();
		  
		Long pessoaId = pessoaEncontrada.getId();
		cadastroPessoaService.excluir(pessoaId);
	    Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
	    assertFalse(pessoa.isPresent());
	  }

}
