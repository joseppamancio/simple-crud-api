package com.crud.test.domain.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.crud.test.domain.model.Pessoa;
import com.crud.test.domain.repository.PessoaRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class BuscarPessoaServiceTest {
	
	  @Autowired
	  private CadastroPessoaService cadastroPessoaService;
	 
	  @Autowired
	  private PessoaRepository pessoaRepository;

	  @Test
	  public void buscarPessoaPorIDTest() {

		Long pessoaId = 2L;
	    Optional<Pessoa> pessoa = cadastroPessoaService.buscarPessoa(pessoaId);
	    assertEquals("Graziela Aparecida de Souza", pessoa.get().getNome());
	    assertEquals(28, pessoa.get().getIdade());
	    assertEquals("51423617843", pessoa.get().getCpf());
	    assertEquals("Recepcionista", pessoa.get().getProfissao());
	  }
	  
	  @Test
	  public void excluirPorIdTest() {
		  
		Long pessoaId =11L;
		cadastroPessoaService.excluir(pessoaId);
	    Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
	    assertFalse(pessoa.isPresent());
	  }
}
