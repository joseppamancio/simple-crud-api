package com.crud.test.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.crud.test.domain.ValidationGroups;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pessoa {

	@Id
	@EqualsAndHashCode.Include
	@NotNull(groups = ValidationGroups.PessoaId.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=100)
	@Column(name = "nome")
	private String nome;
	
	@Column(name="dataNascimento")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(name="estadoCivil")
	private EstadoCivil estadoCivil;
	
	@Column(name="idade")
	private Integer idade;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="profissao")
	private String profissao;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	public Pessoa() {
		super();
	}

	public Pessoa(@NotBlank @Size(max = 100) String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
}
